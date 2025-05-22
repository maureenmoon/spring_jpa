package com.study.spring.selftest;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class EntitySelfJPA {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	private String name;
	private String content;
	private LocalDateTime startdate;
	private Double latitude;
	private Double longitude;
	
	private String selfFileNames;


		
	}
	
	
	


