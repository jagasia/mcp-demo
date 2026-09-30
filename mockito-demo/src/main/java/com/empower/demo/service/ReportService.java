package com.empower.demo.service;

import org.springframework.stereotype.Service;

@Service
public class ReportService {

	private final CalculatorService calculatorService;
	
	public ReportService(CalculatorService calculatorService) {
		this.calculatorService = calculatorService;
	}
	
	public String generateReport(int a, int b) {
		int sum = calculatorService.add(a, b);
		int difference = calculatorService.subtract(a, b);
		return ""+sum +":"+ difference;
	}
}
