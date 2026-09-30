package com.example.calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/calc")
public class CalculatorController {

    @GetMapping("/add")
    public Map<String, Object> add(@RequestParam double a, @RequestParam double b) {
        double result = a + b;
        return Map.of(
                "a", a,
                "b", b,
                "operation", "add",
                "result", result
        );
    }

    @GetMapping("/subtract")
    public Map<String, Object> subtract(@RequestParam double a, @RequestParam double b) {
        double result = a - b;
        return Map.of(
                "a", a,
                "b", b,
                "operation", "subtract",
                "result", result
        );
    }
}
