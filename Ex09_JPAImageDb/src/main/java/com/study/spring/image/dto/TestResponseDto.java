package com.study.spring.image.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestResponseDto {
	
	private Long id;
	
	private String name;
	private String title;
	private String content;
	private List<String> image;

}
