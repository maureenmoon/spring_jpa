package com.study.spring.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.study.spring.security.handler.ApiLoginFailHandler;
import com.study.spring.security.handler.ApiLoginSuccessHandler;

import lombok.extern.log4j.Log4j2;

@Configuration
@EnableMethodSecurity
@Log4j2
public class CustomSecurityConfig {
	
	//password create: 비번 숫자로 된 것을 코드화시켜 시스템에 저장
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	//filter chain
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		log.info("----------------security config------------------");
		
		http.cors(config -> config.disable()); //CORS cross-origin resource sharing
		http.csrf(config -> config.disable()); //session 유지-로그인시 저장하는 값을 막을때 사용
		//lambda  config -> {return () } 단일 실행문이면  { } 생략가능

		http.sessionManagement(config -> 
			config.sessionCreationPolicy(SessionCreationPolicy.STATELESS) //진입점
			);
		http.formLogin(config->{
			
			config.loginPage("/api/member/login"); //기존에 만들어진 인터페이스, controller 불필요. formLogin: 로그인 페이지변경시
			config.successHandler(new ApiLoginSuccessHandler());
			config.failureHandler(new ApiLoginFailHandler());
		}
		);
		//8080정보 요청시 tocken 유무 확인. 토큰 있으면 로그인페이지로 가지말고 메인으로 이동하게
		
		return http.build();
	}
}
