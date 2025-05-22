package com.study.spring.image.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TestDto {
	
	private Long id;
	private String name;
	private String title;
	private String content;
	
	//null도 초기값으로 받아주게 함
	@Builder.Default
	private List<MultipartFile> files = new ArrayList<>();

	@Builder.Default
	private List<String> uploadFileNames = new ArrayList<>();


}
