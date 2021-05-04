package com.hades.labs.calculator.controller;

import com.hades.labs.calculator.crosscutting.Constants;
import com.hades.labs.calculator.service.CalculatorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "*")
@RequestMapping(value = Constants.CALCULATOR)
public class CalculatorController {

    private final CalculatorService calculatorService;

    @GetMapping(value = Constants.SUM, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Double> sum(
            @RequestParam(name = Constants.NUMBER_1) Double number1,
            @RequestParam(name = Constants.NUMBER_2) Double number2
    ){
        return new ResponseEntity<>(calculatorService.sum(number1, number2), HttpStatus.OK);
    }

    @GetMapping(value = Constants.SUBTRACTION, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Double> subtraction(
            @RequestParam(name = Constants.NUMBER_1) Double number1,
            @RequestParam(name = Constants.NUMBER_2) Double number2
    ){
        return new ResponseEntity<>(calculatorService.subtraction(number1, number2), HttpStatus.OK);
    }

    @GetMapping(value = Constants.MULTIPLICATION, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Double> multiplication(
            @RequestParam(name = Constants.NUMBER_1) Double number1,
            @RequestParam(name = Constants.NUMBER_2) Double number2
    ){
        return new ResponseEntity<>(calculatorService.multiplication(number1, number2), HttpStatus.OK);
    }

    @GetMapping(value = Constants.DIVISION, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Double> division(
            @RequestParam(name = Constants.NUMBER_1) Double number1,
            @RequestParam(name = Constants.NUMBER_2) Double number2
    ){
        return new ResponseEntity<>(calculatorService.division(number1, number2), HttpStatus.OK);
    }

}
