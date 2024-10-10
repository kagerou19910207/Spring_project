package com.example.demo.animalsAPI.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.animalsAPI.data.AnimalData;
import com.example.demo.animalsAPI.service.AnimalService;

@Controller
public class AnimalController {
	private final AnimalService animalService;

	public AnimalController(AnimalService animalService) {
		this.animalService = animalService;
	}

	@GetMapping("/animal-search")
	public String showSearchPage(Model model) {
		List<AnimalData> animals = animalService.getAllAnimals();
		model.addAttribute("animals", animals);
		return "animal-search";
	}

	@PostMapping("/animal-detail")
	public String showAnimalDetail(@RequestParam int id, Model model) {
		AnimalData animal = animalService.getAnimalById(id);
		model.addAttribute("animal", animal);
		return "animal-detail";
	}
}
