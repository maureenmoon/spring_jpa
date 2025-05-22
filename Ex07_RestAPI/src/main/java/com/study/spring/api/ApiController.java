package com.study.spring.api;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

	@GetMapping("/")
	public String testapi() {
		return "Hello";
	}
	@GetMapping("/test")
	public Map<String, String> testHello(){
		Map<String, String> response = new HashMap<>();
		response.put("message", "hello world1");
		response.put("test", "hello world21");
		return response;
	}
	@GetMapping("test/{name}/{age}")
	public Map<String, Object> TestRequest(
			@PathVariable("name") String name, 
			@PathVariable("age") Integer age
			) {
		Map<String, Object> response = new HashMap<>();
		response.put("name",  name);
		response.put("age",  age);
		return response;
	}
	//http://localhost:8080/testApi?name=maureen&age=10
	@GetMapping("/test/param")
	public String requestParam(
		@RequestParam("name") String name,
		@RequestParam("age") Integer age
		) {
		return "hi I am "+name+" , age "+age;
	}
	//postmapping은 내가 데이터를 직접 만들어쓸때 사용. get은 만들어진 데이터가져올때
	@PostMapping("/test/body")
	public String requestBody(
		@RequestBody TestRequestDto request
			) {
		return "hi, reqeust-body : name "+request.getName()+", age "+request.getAge();
	}
}