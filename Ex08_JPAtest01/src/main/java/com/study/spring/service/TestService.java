package com.study.spring.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.study.spring.dto.TestDto;
import com.study.spring.entity.TestEntity;
import com.study.spring.repository.TestRepository;

@Service
public class TestService {

	@Autowired
	private TestRepository testRepository;
	
	//Dto->Entity class
	public void createPost(TestDto request) {
		TestEntity testdata = new TestEntity();
		
		testdata.setName(request.getName());
		testdata.setEmail(request.getEmail());
		testdata.setTitle(request.getTitle());
		testdata.setContent(request.getContent());
		testdata.setDatetime(LocalDateTime.now());
	
		testRepository.save(testdata);	
	}

//	public List<TestEntity> findAll() {	
//		return testRepository.findAll(Sort.by(Sort.Direction.DESC,"id"));
//	}
	public Page<TestEntity> findAll(Pageable pageable) {
		return testRepository.findAll(pageable);
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
//검색시 사용할 repository작성
	//findByTitleContainingOrContentContaining(query,pageable)
	public Page<TestEntity> search(String query, Pageable pageable) {
		return testRepository.findByTitleContaining(query,pageable);
	}

}
