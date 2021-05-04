package com.hades.labs.calculator.service.implement;

import com.hades.labs.calculator.service.CalculatorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public Double sum(Double number1, Double number2) {
        return number1 + number2;
    }

    @Override
    public Double subtraction(Double number1, Double number2) {
        return number1 - number2;
    }

    @Override
    public Double multiplication(Double number1, Double number2) {
        return number1 * number2;
    }

    @Override
    public Double division(Double number1, Double number2) {
        try {
            return number1 / number2;
        }catch (Exception e){
            log.error("Error in CalculatorServiceImpl - division {0}", e);
        }
        return null;
    }
}
