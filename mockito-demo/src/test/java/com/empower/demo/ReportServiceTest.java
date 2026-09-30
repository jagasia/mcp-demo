package com.empower.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.empower.demo.service.CalculatorService;
import com.empower.demo.service.ReportService;

@ExtendWith(MockitoExtension.class)
public class ReportServiceTest {
	
	@Mock
	private CalculatorService calculatorService;
	
	@InjectMocks
	private ReportService reportService;
	
	@Test
	public void testGenerateReport() {
		
		when(calculatorService.add(5, 3)).thenReturn(8);
		when(calculatorService.subtract(5, 3)).thenReturn(2);
		when(calculatorService.add(10, 4)).thenReturn(14);
		when(calculatorService.subtract(10, 4)).thenReturn(6);
		
		String actual = reportService.generateReport(5, 3);
		String expected = "8:2";
		
		assertEquals(expected, actual);

		actual=reportService.generateReport(10, 4);
		expected="14:6";
		
		assertEquals(expected, actual);
	}

}
