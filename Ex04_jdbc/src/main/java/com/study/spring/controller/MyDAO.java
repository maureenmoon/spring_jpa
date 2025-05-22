package com.study.spring.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MyDAO {
//	bean 등록. container에서 저장, autowired를 사용하여 외부에 관리
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<MyDTO> list(){
		String query2 = "select * from simple_bbs";
		List<MyDTO> list2 = jdbcTemplate.query(
				query2, new BeanPropertyRowMapper<>(MyDTO.class) 
				);
		
		return list2;
	}
}
