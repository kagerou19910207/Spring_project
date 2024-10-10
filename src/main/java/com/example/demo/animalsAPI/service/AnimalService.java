package com.example.demo.animalsAPI.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.animalsAPI.data.AnimalData;
import com.example.demo.animalsAPI.repository.AnimalRepository;

@Service
public class AnimalService {
	private final AnimalRepository repository;

	public AnimalService(AnimalRepository repository) {
		this.repository = repository;
	}

	public List<AnimalData> getAllAnimals() {
		return repository.findAll();
	}

	public AnimalData getAnimalById(int id) {
		return repository.findById(id);
	}
}
