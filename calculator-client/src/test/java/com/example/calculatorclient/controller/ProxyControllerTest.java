package com.example.calculatorclient.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Pure unit test: no Spring context, no HTTP. The RestTemplate is a Mockito mock,
 * so the real calculator service is never called.
 */
@ExtendWith(MockitoExtension.class)
class ProxyControllerTest {

    private static final String BASE_URL = "http://localhost:8080";

    @Mock
    private RestTemplate restTemplate;

    @Captor
    private ArgumentCaptor<URI> uriCaptor;

    private ProxyController proxyController;

    @BeforeEach
    void setUp() {
        // @InjectMocks cannot supply the String base URL, so build the controller by hand
        proxyController = new ProxyController(restTemplate, BASE_URL);
    }

    @Test
    void addShouldReturnCalculatorServiceResponse() {
        ResponseEntity<Map> calculatorResponse = new ResponseEntity<>(
                Map.of("a", 5.0, "b", 3.0, "operation", "add", "result", 8.0), HttpStatus.OK);
        when(restTemplate.getForEntity(any(URI.class), eq(Map.class))).thenReturn(calculatorResponse);

        ResponseEntity<Map> response = proxyController.add(5, 3);

        assertSame(calculatorResponse, response);
        assertEquals(8.0, response.getBody().get("result"));
    }

    @Test
    void addShouldCallCorrectCalculatorUrl() {
        when(restTemplate.getForEntity(any(URI.class), eq(Map.class)))
                .thenReturn(new ResponseEntity<>(Map.of(), HttpStatus.OK));

        proxyController.add(5, 3);

        verify(restTemplate).getForEntity(uriCaptor.capture(), eq(Map.class));
        assertEquals(URI.create(BASE_URL + "/api/calc/add?a=5.0&b=3.0"), uriCaptor.getValue());
    }

    @Test
    void subtractShouldReturnCalculatorServiceResponse() {
        ResponseEntity<Map> calculatorResponse = new ResponseEntity<>(
                Map.of("a", 10.0, "b", 4.0, "operation", "subtract", "result", 6.0), HttpStatus.OK);
        when(restTemplate.getForEntity(any(URI.class), eq(Map.class))).thenReturn(calculatorResponse);

        ResponseEntity<Map> response = proxyController.subtract(10, 4);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("subtract", response.getBody().get("operation"));
        assertEquals(6.0, response.getBody().get("result"));
    }

    @Test
    void subtractShouldCallCorrectCalculatorUrl() {
        when(restTemplate.getForEntity(any(URI.class), eq(Map.class)))
                .thenReturn(new ResponseEntity<>(Map.of(), HttpStatus.OK));

        proxyController.subtract(10, 4);

        verify(restTemplate).getForEntity(uriCaptor.capture(), eq(Map.class));
        assertEquals(URI.create(BASE_URL + "/api/calc/subtract?a=10.0&b=4.0"), uriCaptor.getValue());
    }

    @Test
    void addShouldPropagateErrorWhenCalculatorServiceIsDown() {
        when(restTemplate.getForEntity(any(URI.class), eq(Map.class)))
                .thenThrow(new ResourceAccessException("Connection refused"));

        assertThrows(ResourceAccessException.class, () -> proxyController.add(5, 3));
    }
}
