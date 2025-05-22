package com.study.spring.service2;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.study.spring.dto2.TestDto;
import com.study.spring.entity2.TestEntity;
import com.study.spring.repository2.TestRepository;

@Service
public class TestService {
	
	@Autowired
	private TestRepository testRepository;

	public void createPost(TestDto request) {
		TestEntity testdata = new TestEntity();
		
		testdata.setName(request.getName());
		testdata.setEmail(request.getEmail());
		testdata.setTitle(request.getTitle());
		testdata.setContent(request.getContent());
		testdata.setDatetime(LocalDateTime.now());
		
		testRepository.save(testdata);	
	}

	public List<TestEntity> findAll() {

		return testRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
	}

	public void delete(Long id) {
		TestEntity testEntity = testRepository.findById(id).get();
		testRepository.delete(testEntity);
	}

	public void update(Long id, String name, String title, String content) {
		TestEntity testEntity = testRepository.findById(id).orElseThrow();
		testEntity.changeNameTitleContent(name,title,content);
		testRepository.save(testEntity);		
	}
}
