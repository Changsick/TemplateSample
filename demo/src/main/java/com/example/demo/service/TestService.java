package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.TestTbVO;
import com.example.demo.repository.TestRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TestService {
	
	private final TestRepository testRepository;
	
	public List<TestTbVO> getTestData() {
		
		return testRepository.findAll();
	}

}
