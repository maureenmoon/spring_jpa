package com.study.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//접근권한 설정파일이라는 의미
@Configuration
public class CustomServletConfig implements WebMvcConfigurer {

	//Cross-Origin Resource Sharing: 다른 출처의 리소스 공유에 대한 허용/비허용을 다룬 정책.API
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		
		
	    registry.addMapping("/**")
        		.allowedOrigins("*")
        		.allowedMethods("HEAD", "GET", "POST", "PUT", "DELETE", "OPTIONS")
        		.maxAge(300)
        		.allowedHeaders("Authorization", "Cache-Control", "Content-Type");
	}


}
