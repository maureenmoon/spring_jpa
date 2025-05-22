package com.study.spring.controller2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.spring.dto2.TestDto;
import com.study.spring.entity2.TestEntity;
import com.study.spring.service2.TestService;

@RestController
public class TestController {
	
	@Autowired
	private TestService testService;
	
	@GetMapping("/")
	public String test() {
		return "hi";
	}

	//create
	@PostMapping("/test")
	public void createPostTest(
			@RequestBody TestDto request
			) {
		testService.createPost(request);
	}
	//read
	@GetMapping("/test")
	public List<TestEntity> testList(){
		return testService.findAll();
	
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
		testService.update(
				id,
				request.getName(),
				request.getTitle(),
				request.getContent()
				);
		
	}
}
