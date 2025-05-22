package com.study.spring.uploading;

import org.springframework.web.multipart.MultipartFile;
import lombok.Data;

@Data
public class UploadingDto {
	
	private String title;
	private String name;
	private String content;
	
	private MultipartFile files;

}
