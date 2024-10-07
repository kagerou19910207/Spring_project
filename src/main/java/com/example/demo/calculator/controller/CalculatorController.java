package com.example.demo.calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.calculator.service.CalculatorService;

@Controller
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("calculator")
    public String showForm() {
        return "calculator";
    }

    @PostMapping("calculator")
    public String calculate(@RequestParam("number1") int number1,
                            @RequestParam("number2") int number2,
                            @RequestParam("operator") String operator,
                            Model model) {
        String resultMessage;

        try {
            int result;

            switch (operator) {
                case "-":
                    result = calculatorService.subtract(number1, number2);
                    resultMessage = String.valueOf(result);
                    break;
                case "+":
                    result = calculatorService.add(number1, number2);
                    resultMessage = String.valueOf(result);
                    break;
                case "*":
                    result = calculatorService.multiply(number1, number2);
                    resultMessage = String.valueOf(result);
                    break;
                case "/":
                    result = calculatorService.divide(number1, number2);
                    resultMessage = String.valueOf(result);
                    break;
                default:
                    resultMessage = "ゼロ除算はできません";
            }
        } catch (ArithmeticException e) {
            resultMessage = "ゼロ除算はできません";
        }

        model.addAttribute("result", resultMessage);
        return "calculator";
    }
}