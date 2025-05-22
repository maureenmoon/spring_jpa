package com.study.spring.selftest;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class DtoSelfJPA {
	private String title;
	private String name;
	private String content;

	private Double latitude;
	private Double longitude;
	
	private MultipartFile files;
	

}
