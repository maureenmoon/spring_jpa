package com.study.spring.test;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CustomServletConfig implements WebMvcConfigurer{

	//Ctl+Alt+S/Override선택후 addCorsMappings선택하여 사용
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		
		  registry.addMapping("/**")
          .allowedOrigins("*")
          .allowedMethods("HEAD", "GET", "POST", "PUT", "DELETE", "OPTIONS")
          .maxAge(300)
          .allowedHeaders("Authorization", "Cache-Control", "Content-Type");
	}
	

}
