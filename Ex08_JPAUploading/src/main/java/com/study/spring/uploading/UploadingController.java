package com.study.spring.uploading;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UploadingController {
	
	@Autowired
	public UploadingService uploadingService;
	
	@GetMapping("/")
	public String root() {
		return "hi2";
	}
	//create
	// ModelAttribute: form-data받을때 사용 vs. RequestParam: id받을때
	@PostMapping("/test")
	public void uploadingCreate(@ModelAttribute UploadingDto uploadingDto) {
		uploadingService.uploadingCreate(uploadingDto);
	}
	

}
