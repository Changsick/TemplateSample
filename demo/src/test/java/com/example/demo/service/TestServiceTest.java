package com.example.demo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

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
		
		// When: 서비스 메서드 호출
	    List<TestTbVO> result = testService.getTestData();

	    // Then: 결과 검증
	    assertEquals(result.get(0).getTestPk(), Long.valueOf(1L));
	    assertEquals(result.get(1).getTestPk(), Long.valueOf(2L));
	    then(testRepository).should(times(1)).findAll();
	 // 후속 상호작용이 없었는지 검증
	    then(testRepository).shouldHaveNoMoreInteractions();
	}

}
