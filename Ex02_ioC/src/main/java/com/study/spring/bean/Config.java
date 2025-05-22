package com.study.spring.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
	
	@Bean
	public Member member1() {
		Member member11 =new Member();
		member11.setName("Hong");
		member11.setName("Dosa");
		member11.setPrinter(new PrinterA());
		return member11;
	}
	@Bean(name="hello")
	public Member member2() {
		return new Member("Chonwoochi", "Doda",new PrinterB());
	}
}
