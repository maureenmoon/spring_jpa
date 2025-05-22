package com.study.spring.test;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RestController;

//이 클래스가 controller임을 나타냄
@RestController
public class TestImgController {
	
	@Autowired
	public TestImgService testImgService;
	
	//uploadPath변수에 외부 설정 파일에서 읽어온 파일 업로드 경로를 주입. application 정의되어있어야함
	@Value("${file.upload-dir}")
	private String uploadDir;
	
	@GetMapping("/")
	public String root() {
		return "hi";
	}
	//FoamData->ModelAttribute
	@PostMapping("/test")
	public void testCreate(
			@ModelAttribute TestImgDto testImgDto) {
		testImgService.testImgCreate(testImgDto);	
	}
	//upload img-files from a upload folder to URL
	//주소창 참조시->PathVariable vs. queryParam->RequestParam
	//http://localhost:8080/img/filename
	//react <img src={`http://localhost:8080/img/thumb_${item.filename}`}>
	@GetMapping("/images/{filename}")
	public ResponseEntity<Resource> getImg(
			@PathVariable("filename") String filename
			) throws IOException {
		File file = new File(uploadDir + filename);
		System.out.println(file.toString());
		
		if(!file.exists()) {
			System.out.println("file not existed");
			return ResponseEntity.notFound().build();
		}
		
		Resource resource = new FileSystemResource(file);
		
		String contentType = Files.probeContentType(file.toPath());
		System.out.println(contentType.toString());
		
		//binary type file받을때
		if(contentType == null) {
			contentType = "application/octet-stream";
		}
		
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(contentType))
				.body(resource);
	}
//	@GetMapping("/test")
//	public List<TestImgEntity> testList(){
//		List<TestImgEntity> data = testImgService.findAll();
//		return data;
//	}
	
	//pagination-위의 List<> 형식으로 작성후 변경:testList
	//@PageableDefault)page: Pageable pageable, List->Page
	@GetMapping("/test")
	public ResponseEntity<Page<TestImgEntity>> testList(
			@PageableDefault(size=2, sort="id", direction = Sort.Direction.DESC)
			Pageable pageable
			){
		Page<TestImgEntity> data = testImgService.findAll(pageable);
		return ResponseEntity.ok(data);
	}
}

