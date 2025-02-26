package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.TestTbVO;
import com.example.demo.service.TestService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TestRestController {
	
	private final TestService testService;

	@GetMapping("/test1")
	public String test1(@RequestParam(name = "val1") String val1) { // @RequestParam String val1
		System.out.println(val1);
		List<TestTbVO> dataList = testService.getTestData();
//		System.out.println("val1 : " + val1);
		System.out.println("dataList : " + dataList);
		return "success";
	}
	
}
