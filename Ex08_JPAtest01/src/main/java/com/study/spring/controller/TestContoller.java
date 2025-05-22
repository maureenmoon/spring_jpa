package com.study.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.spring.dto.TestDto;
import com.study.spring.entity.TestEntity;
import com.study.spring.service.TestService;

@RestController //API 가져다 쓰게해줌
@CrossOrigin(origins = "*") //frt <=> DB
public class TestContoller {
	
	@Autowired
	private TestService testService;
	
	@GetMapping("/")
	public String test() {
		return "hi, Spring";
	}

	//create
	//@PathValue @Param @RequestBody @ModelAttribute 어떤형태로 받을지 정해야함
	//Postman body에 데이터입력
	@PostMapping("/test")
	public void createPostTest( 
		@RequestBody TestDto request) {
		testService.createPost(request);
	}
	//read Postman startPage=0
	@GetMapping("/test")
	public Page<TestEntity> testList(Pageable pageable){
		return testService.findAll(pageable);
	}
	
	//delete
	@DeleteMapping("/test")
	public void testDelete(
			@RequestParam("id") Long id
			) {
		testService.delete(id);
	}
	//update
	@PutMapping("/test")
	public void testUpdate(
			@RequestParam("id") Long id,
			@RequestBody TestDto request
			) {
		testService.update(id,
				request.getName(),
				request.getTitle(),
				request.getContent()
				);
	}
	//search(query)& pageable 같이 사용.?page=0&size=5&query=jpa
	@GetMapping("/test/search")
	public ResponseEntity<Page<TestEntity>> testList(
			@RequestParam("query") String query,
			Pageable pageable
			){
		Page<TestEntity> data = testService.search(query, pageable);		
		return ResponseEntity.ok(data);
	}
	
}
	
