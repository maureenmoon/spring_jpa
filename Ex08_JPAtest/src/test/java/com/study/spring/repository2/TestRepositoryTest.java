package com.study.spring.repository2;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.spring.entity2.TestEntity;

@SpringBootTest
public class TestRepositoryTest {
	
	@Autowired
	private TestRepository testRepository;
	
	@Test
	public void testInsert() {
		for(var i=1;i<=10;i++) {
			TestEntity test = new TestEntity();
			
			test.setName("maureen"+i);
			test.setEmail("susiemoon7"+i+"@naver.com");
			test.setContent("test contentcontent"+i);
			test.setTitle("title test"+i);
			test.setDatetime(LocalDateTime.now());
			
			testRepository.save(test);
		}
	}
}
