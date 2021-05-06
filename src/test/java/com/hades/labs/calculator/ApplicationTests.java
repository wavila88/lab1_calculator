package com.hades.labs.calculator;

import com.hades.labs.calculator.controller.CalculatorController;
import com.hades.labs.calculator.service.CalculatorService;
import com.hades.labs.calculator.service.implement.CalculatorServiceImpl;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@SpringBootTest
class ApplicationTests {

	private CalculatorServiceImpl calculatorServiceImpl = new CalculatorServiceImpl();
	@Test
	void contextLoads() {
		Double response = calculatorServiceImpl.sum(1d,2d);
		Assert.assertEquals(java.util.Optional.of(response), java.util.Optional.of(3d));
	}

}
