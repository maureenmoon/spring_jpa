package com.study.spring.security.handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import com.google.gson.Gson;
import com.study.spring.member.dto.MemberDto;
import com.study.spring.util.JWTUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ApiLoginSuccessHandler implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		log.info("####################################");
		log.info(authentication);
		log.info("####################################");
		
		//tocken 발행
		MemberDto memberDto = (MemberDto)authentication.getPrincipal(); //형변환
		
		Map<String, Object> claims = memberDto.getClaims();
		
		String accessToken = JWTUtil.generateToken(claims, 10);//10min
		String refreshToken = JWTUtil.generateToken(claims, 60*24);
		
//		claims.put("accessToken", "1");
//		claims.put("refreshToken", "2");
		claims.put("accessToken", accessToken);
		claims.put("refreshToken", refreshToken);
		
		//Gson: 기본 데이터 유형, 컬렉션(List, Map), 사용자 정의 객체 등 수많은 종류의 data 객체를 Json으로 변환
		Gson gson = new Gson();
		String jsonStr = gson.toJson(claims);
		
		response.setContentType("application/json;charset=UTF-8");
		//PrintWriter json출력
		PrintWriter printWriter = response.getWriter();
		printWriter.println(jsonStr);
		printWriter.close();
	}
	

}
