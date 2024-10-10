package com.example.demo.animalsAPI.repository;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.example.demo.animalsAPI.data.AnimalData;

@Repository
public class AnimalRepository {
	private final String BASE_URL = "https://wsaz0e6z45.execute-api.ap-northeast-1.amazonaws.com/prod/animalsAPI";
	private final RestTemplate restTemplate = new RestTemplate();

	public List<AnimalData> findAll() {
		AnimalData[] animals = restTemplate.getForObject(BASE_URL, AnimalData[].class);
		return Arrays.asList(animals);
	}

	public AnimalData findById(int id) {
		AnimalData[] animalArray = restTemplate.getForObject(BASE_URL + "?id=" + id, AnimalData[].class);
		if (animalArray != null && animalArray.length > 0) {
			System.out.println("取得した動物データ: " +
					"ID: " + animalArray[0].getId() + ", " +
					"英名: " + animalArray[0].getName() + ", " +
					"和名: " + animalArray[0].getJapanese_name() + ", " +
					"鳴き声: " + animalArray[0].getCry());
			return animalArray[0];
		}
		return null;
	}
}