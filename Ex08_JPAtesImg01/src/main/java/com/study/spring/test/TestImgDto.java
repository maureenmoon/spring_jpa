package com.study.spring.test;

import org.springframework.web.multipart.MultipartFile;
import lombok.Data;

@Data
public class TestImgDto {
	private String title;
	private String name;
	private String content;
	private MultipartFile files;
}
