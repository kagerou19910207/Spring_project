package com.example.demo.minus.service;

import org.springframework.stereotype.Service;

@Service
public class MinusService {
	public int subtract(int a, int b) {
		return a - b;
	}
}