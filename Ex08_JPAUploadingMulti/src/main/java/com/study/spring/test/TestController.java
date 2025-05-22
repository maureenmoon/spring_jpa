package com.study.spring.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {
	
	@Autowired
	private TestService testService;
	
	@Value("${file.upload-dir}")
	private String uploadDir;
	
	@GetMapping("/")
	public String root() {
		return "hi";
	}

//create(1)
//	@PostMapping("/test")
//	public String testCraete(
//			@ModelAttribute TestDto request		
//			) {		
//		System.out.println(request.toString());		
//		return null;	
//	}
//create(2)
//	@PostMapping("/test")
//	public String testCraete(
//			@ModelAttribute TestDto request		
//			
//			) throws IllegalStateException, IOException {	
//		System.out.println(request.toString());	
//		testService.testCreate(request);
//		return null;	
//	}
	//create(3)
	@PostMapping("/test")
	public ResponseEntity<Map<String, String>> testCraete(
			@ModelAttribute TestDto request		
			
			) throws IllegalStateException, IOException {	
//		System.out.println(request.toString());	
		
		Map<String, String> response = new HashMap<>();
		
		try { 
			
			testService.testCreate(request);
			response.put("message", "ok");
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		} catch (Exception e) {
			
			response.put("message", "ok");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);	
		}
	}
	//read1
//	@GetMapping("/test")
//	public List<TestEntity> testList(){
//		List<TestEntity> data = testService.findAll();
//		return data;
	//read2
//	@GetMapping("/test")
//	public List<TestResponseDto> testList(){
//		List<TestResponseDto> data = testService.findAll();
//		return data;
//	} 
	//read3 pagination
	@GetMapping("/test")
	public ResponseEntity<Page<TestResponseDto>> testList(
			@PageableDefault(size=10,sort="id",direction=Sort.Direction.DESC) //Direction까지 입력후 Sort연결해야함
			Pageable pageable){
		Page<TestResponseDto> data = testService.findAll(pageable);
		return ResponseEntity.ok(data);
	} 
	//image file가져오기
	//http://localhost:8080/images/실제 화일이름.확장자명
	//react <img src={`http://localhost:8080/images/thumb_${item.filename}`}>
	@GetMapping("/images/{filename}")
	public ResponseEntity<Resource> getImage(
			@PathVariable("filename") String filename
			) throws IOException{
		File file = new File(uploadDir + filename);
		if(!file.exists()) {
			return ResponseEntity.notFound().build();//본문 바디에 비워진체 반응시
		}
		Resource resource = new FileSystemResource(file);
		
		String contentType = Files.probeContentType(file.toPath());
		
		//binary type file받을때
		if(contentType == null) {
			contentType = "application/octet-stream";
		}

		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(contentType))
				.body(resource);
	}
	//search-ReqeustParam
	//test/search?query=홍길동&page=0&size=10
	//ResponseEntity json형태로 바꿔줄때 사용
	@GetMapping("/test/search")
	public ResponseEntity<Page<TestResponseDto>> testSearch(
			@RequestParam("query") String query,
			@PageableDefault(size=10,sort="id",direction=Sort.Direction.DESC) 
			//Direction까지 입력후 Sort연결해야함
			Pageable pageable){
		Page<TestResponseDto> data = testService.findAll(query,pageable);
		return ResponseEntity.ok(data);
	}	
	
	//view
	@GetMapping("/test/{id}")
	public ResponseEntity<TestResponseDto> testViewId(@PathVariable("id") Long id) {
		Optional<TestEntity> optional = testService.findById(id);
		
		if(optional.isPresent()) {
			return ResponseEntity.ok(new TestResponseDto(optional.get()));	
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	//Delete
	@DeleteMapping("/test/{id}")
	public ResponseEntity<String> testDelete(
			@PathVariable("id") Long id
			){
		boolean isDeleted = testService.testDelete(id);
		System.out.println("data check" + isDeleted);	
		return ResponseEntity.status(HttpStatus.OK).body("delete is completed");
	}
}
