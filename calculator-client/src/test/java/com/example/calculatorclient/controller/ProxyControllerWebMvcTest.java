package com.example.calculatorclient.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Web-layer test: real HTTP handling (URL mapping, request params, JSON) via MockMvc,
 * with the RestTemplate bean replaced by a Mockito mock.
 */
@WebMvcTest(ProxyController.class)
class ProxyControllerWebMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private RestTemplate restTemplate;

    @Test
    void addEndpointShouldReturnCalculatorResult() throws Exception {

      
        ResponseEntity<Map> calculatorResponse = new ResponseEntity<>(
                Map.of("a", 5.0, "b", 3.0, "operation", "add", "result", 8.0), HttpStatus.OK);
        when(restTemplate.getForEntity(any(URI.class), eq(Map.class))).thenReturn(calculatorResponse);

        mockMvc.perform(get("/proxy/add").param("a", "5").param("b", "3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.operation").value("add"))
                .andExpect(jsonPath("$.result").value(8.0));

        verify(restTemplate).getForEntity(URI.create("http://localhost:8080/api/calc/add?a=5.0&b=3.0"), Map.class);
    }

    @Test
    void subtractEndpointShouldReturnCalculatorResult() throws Exception {
        ResponseEntity<Map> calculatorResponse = new ResponseEntity<>(
                Map.of("a", 10.0, "b", 4.0, "operation", "subtract", "result", 6.0), HttpStatus.OK);
        when(restTemplate.getForEntity(any(URI.class), eq(Map.class))).thenReturn(calculatorResponse);

        mockMvc.perform(get("/proxy/subtract").param("a", "10").param("b", "4"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.operation").value("subtract"))
                .andExpect(jsonPath("$.result").value(6.0));
    }

    @Test
    void missingParameterShouldReturn400WithoutCallingCalculator() throws Exception {
        mockMvc.perform(get("/proxy/add").param("a", "5"))
                .andExpect(status().isBadRequest());

        verifyNoInteractions(restTemplate);
    }
}
