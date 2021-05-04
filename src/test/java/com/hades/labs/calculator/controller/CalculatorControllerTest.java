package com.hades.labs.calculator.controller;


import com.hades.labs.calculator.service.implement.CalculatorServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;

import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.when;

class CalculatorControllerTest {

    @Mock
    private CalculatorController calculatorController;
    @InjectMocks
    private CalculatorServiceImpl calculatorService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
        ReflectionTestUtils.setField(calculatorController, "calculatorService", calculatorService);
        when(calculatorController.sum(anyDouble(), anyDouble())).thenCallRealMethod();
        when(calculatorController.subtraction(anyDouble(), anyDouble())).thenCallRealMethod();
        when(calculatorController.multiplication(anyDouble(), anyDouble())).thenCallRealMethod();
        when(calculatorController.division(anyDouble(), anyDouble())).thenCallRealMethod();
    }

    @Test
    void sumTest(){
        ResponseEntity result = calculatorController.sum(new Double(4), new Double(8));
        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
        Assertions.assertEquals(new Double(12), (Double) result.getBody());
    }

    @Test
    void subtractionTest(){
        ResponseEntity result = calculatorController.subtraction(new Double(8), new Double(4));
        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
        Assertions.assertEquals(new Double(4), (Double) result.getBody());
    }

    @Test
    void multiplicationTest(){
        ResponseEntity result = calculatorController.multiplication(new Double(4), new Double(8));
        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
        Assertions.assertEquals(new Double(32), (Double) result.getBody());
    }

    @Test
    void divisionTest(){
        ResponseEntity result = calculatorController.division(new Double(8), new Double(4));
        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
        Assertions.assertEquals(new Double(2), (Double) result.getBody());
    }
}