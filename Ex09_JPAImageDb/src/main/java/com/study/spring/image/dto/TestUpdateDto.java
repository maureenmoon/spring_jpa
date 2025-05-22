package com.study.spring.image.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TestUpdateDto {
	private Long id;
	
	private String name;
	private String title;
	private String content;

	//첨부화일에 대한 existing file, update file, new file 필요
	
	private List<String> updatedFileNames = new ArrayList<>();
	private List<MultipartFile> files = new ArrayList<>();
	private List<String> newUploadedFileNames = new ArrayList<>();

}
