package com.study.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// ec2 server WAS 실행하게 함
public class Ex02IoCAnnotationApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ex02IoCAnnotationApplication.class, args);
	}

}
