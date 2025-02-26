package com.example.demo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.model.TestTbVO;
import com.example.demo.repository.TestRepository;

//import lombok.extern.slf4j.Slf4j;

@ExtendWith(MockitoExtension.class)
class TestServiceTest {

	@Mock TestRepository testRepository;
	
	@InjectMocks TestService testService;
	
	
	@BeforeEach
	void setUp() {
	}
	
	@Test
	@DisplayName("데이터 가져오기")
	void test_getData() {
		List<TestTbVO> list = Arrays.asList(
				TestTbVO.setAllArgsBuilder()
				.testPk(1L)
				.testCol1(1)
				.testCol2("test1")
				.build(),
				TestTbVO.setAllArgsBuilder()
				.testPk(2L)
				.testCol1(2)
				.testCol2("test2")
				.build());
//		given
		given(testRepository.findAll()).willReturn(list);
		
		// When
        List<TestTbVO> result = testService.getTestData();
        
        assertThat(result).hasSize(2);
        assertThat(result.get(0).getTestPk()).isEqualTo(1L);
	}

}
