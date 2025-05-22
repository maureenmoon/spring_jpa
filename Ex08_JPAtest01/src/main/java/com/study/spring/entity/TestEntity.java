package com.study.spring.entity;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data //@Data : getter setter
//@Getter
@Table(name="testtable") //@Table : DB table생성
public class TestEntity {
	
	@Id //primary-key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;  //primary-key(@ID) and auto-increment(@GeneraledValue)
	
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