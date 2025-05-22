package com.study.spring.selftest;

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

@RestController
public class ControllerSelfJPA {
	
	@Autowired
	public ServiceSelfJPA serviceSelfJPA;
	
	//uploading dir
	@Value("${file.upload-dir}")
	public String uploadDir2;

	@GetMapping("/")
	public String root() {
		return "hi3";	
	}

	//create FoamData
	@PostMapping("/test")
	public void testCreate(
			@ModelAttribute DtoSelfJPA dtoSelfJPA) {
		serviceSelfJPA.uploadingCreate(dtoSelfJPA);
	}
	
	//uploading
	@GetMapping("/images/{filename}")
	public ResponseEntity<Resource> getImage(
			@PathVariable("filename") String filename
			) throws IOException {
		File file = new File(uploadDir2 + filename);
		System.out.println(file.toString());
		
		if(!file.exists()) {
			System.out.println("file not existed");
			return ResponseEntity.notFound().build();
		}
		
		Resource resource = new FileSystemResource(file);
		String contentType = Files.probeContentType(file.toPath());
		System.out.println(contentType.toString());
		
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(contentType))
				.body(resource);			
	}
	
	//pagination : List<> 형식으로 작성후 변경.ResponseEntity로 먼저 감싸라
	@GetMapping("/test")
	public ResponseEntity<Page<EntitySelfJPA>> selfList(
			@PageableDefault(size=2,sort="id",direction=Sort.Direction.DESC)
			Pageable pageable
			){
		Page<EntitySelfJPA> data = serviceSelfJPA.findAll(pageable);
	return ResponseEntity.ok(data);
	}	
}
