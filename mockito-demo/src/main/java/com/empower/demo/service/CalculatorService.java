package com.empower.demo.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
	
	public int add(int a, int b) {
		return a + b+2;
	}
	
	public int subtract(int a, int b) {
		return a - b+2;
	}
}
