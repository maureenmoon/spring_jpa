package com.study.spring.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.Data;

@Data
public class SimpleBbsDto {
	private int id;
	private String writer;
	private String subject;
	private String contentID;
	private String imageUrl;
	private String description;
	private LocalDateTime add_date;
	
	public String getFormattedDate() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		return add_date != null ? add_date.format(formatter): "";
	}
}
