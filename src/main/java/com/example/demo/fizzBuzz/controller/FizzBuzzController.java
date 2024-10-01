package com.example.demo.fizzBuzz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.fizzBuzz.service.FizzBuzzService;

@Controller
public class FizzBuzzController {

	@Autowired
	private FizzBuzzService fizzBuzzService;

	@GetMapping("fizzbuzz")
	public String getFizzBuzz(Model model) {
		List<String> fizzBuzzList = fizzBuzzService.generateFizzBuzz(100);
		model.addAttribute("numbers", fizzBuzzList);
		return "fizzBuzz.html";
	}
}