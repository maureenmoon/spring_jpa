package com.study.spring.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.Data;

@Data
public class SimpleBbsDto {
	private int id;
	private String article;
	private LocalDateTime add_date;
	private String press;
	
//	private String content;
	
//	date format변경시 getter필요
	public String getFormattedDate() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
		
		return add_date != null ? add_date.format(formatter) : "";

	}
	
	
	

}
