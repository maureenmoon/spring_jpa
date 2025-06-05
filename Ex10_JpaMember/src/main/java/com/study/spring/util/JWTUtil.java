package com.study.spring.util;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Map;
import javax.crypto.SecretKey;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JWTUtil {
	
	private static String key = "123456789123456789123456789123456789"; //github에 올리면 난리난다

	public static String generateToken(Map<String, Object> claims, int i) {

		SecretKey key = null;
		
		try {
			key = Keys.hmacShaKeyFor(JWTUtil.key.getBytes("UTF-8")); //암호화 알고리즘
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		
		String jwtStr = Jwts.builder()
				.setHeader(Map.of("typ","JWT")) //HEADER algorism
				.setClaims(claims)  //기져오는 정보
				.setIssuedAt(Date.from(ZonedDateTime.now().toInstant())) // start date
				.setExpiration(Date.from(ZonedDateTime.now().plusMinutes(i).toInstant())) //expire
				.signWith(key)
				.compact();
		
		return jwtStr;
	}

}
