package com.example.calculatorclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Map;

@RestController
@RequestMapping("/proxy")
public class ProxyController {

    private final RestTemplate restTemplate;
    private final String calculatorBaseUrl;

    public ProxyController(RestTemplate restTemplate, @Value("${calculator.service.url:http://localhost:8080}") String calculatorBaseUrl) {
        this.restTemplate = restTemplate;
        this.calculatorBaseUrl = calculatorBaseUrl;
    }

    @GetMapping("/add")
    public ResponseEntity<Map> add(@RequestParam double a, @RequestParam double b) {
        URI uri = UriComponentsBuilder.fromUriString(calculatorBaseUrl)
                .path("/api/calc/add")
                .queryParam("a", a)
                .queryParam("b", b)
                .build().toUri();
        return restTemplate.getForEntity(uri, Map.class);
    }

    @GetMapping("/subtract")
    public ResponseEntity<Map> subtract(@RequestParam double a, @RequestParam double b) {
        URI uri = UriComponentsBuilder.fromUriString(calculatorBaseUrl)
                .path("/api/calc/subtract")
                .queryParam("a", a)
                .queryParam("b", b)
                .build().toUri();
        return restTemplate.getForEntity(uri, Map.class);
    }
}
