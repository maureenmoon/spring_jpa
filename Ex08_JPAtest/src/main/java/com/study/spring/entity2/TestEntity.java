package com.study.spring.entity2;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="testjpatable")
public class TestEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String email;
	private String title;
	private String content;
	private LocalDateTime datetime;
	private LocalDateTime updatetime;
	
	public void changeNameTitleContent(String name, String title, String content) {
		this.name = name;
		this.title = title;
		this.content = content;
		this.updatetime = LocalDateTime.now();
		
	}
}
