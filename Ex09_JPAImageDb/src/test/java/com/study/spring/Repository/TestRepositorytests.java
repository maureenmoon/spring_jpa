package com.study.spring.Repository;

import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.study.spring.image.entity.TestEntity;
import com.study.spring.image.repository.TestRepository;

@SpringBootTest
public class TestRepositorytests {

	@Autowired
	private TestRepository testRepository;
	
	@Test
	public void testInsert() {
		TestEntity test = TestEntity.builder()
				.name("maureen2")
				.title("hi2")
				.content("testContent2")
				.build();
				
		test.addImageString(UUID.randomUUID()+"_"+"test1.jpg");
		test.addImageString(UUID.randomUUID()+"_"+"test2.jpg");
		
		testRepository.save(test);
	}

}
