package com.study.spring.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.study.spring.dto.SimpleBbsDto;

@Repository
public class SimpleBbsDao implements ISimpleBbsDao {
	
	@Autowired
	JdbcTemplate template;
	
	@Override
	public int writeDao(String writer, String title, String content) {
//		write는 0,1 두가지값만 있어서 int type사용
		System.out.println("----------writeDao run---------------");
		String query = "insert into simple_bbs (writer, title, content) values ( ?, ?, ? )";
		// mysql 데이터삽입 :  insert into table-name (column-name, column-name) value
		return template.update(query, writer, title, content);
//		null나올 경우가 생김. 객체형태로 보내야함. 
	}
	
	@Override
	public List<SimpleBbsDto> listDao(int page, int size) {
//		객체형태
		System.out.println("---listDao run---");
		// page=2&size=3
		int offset = (page -1)*size;
		
		String query = "select * from simple_bbs order by id desc limit ? offset ?";
		
		List<SimpleBbsDto> list = template.query(
				query, new BeanPropertyRowMapper<>(SimpleBbsDto.class), size, offset
//				query는 여러개의 결과를 리스트로 변환, queryForObject는 한개결과를 객체로 변환
				);
		return list;
	}

	@Override
	public Integer countDao() {
		System.out.println("---countDao() run-----");
		String query = "select count(*) from simple_bbs";
		Integer count = template.queryForObject(query, Integer.class);
		
		return count;
	}
	@Override
	public SimpleBbsDto viewDao(String id) {
		System.out.println("---viewDao() run-----");
		String query = "select * from simple_bbs where id = " +id;
		SimpleBbsDto view = template.queryForObject(
				query, new BeanPropertyRowMapper<>(SimpleBbsDto.class)
				);
		return view;
	}

	@Override
	public int deleteDao(String id) {
		System.out.println("---deleteDao() run-----");
		String query = "delete from simple_bbs where id = ?";
		return template.update(query, Integer.parseInt(id));
	}
}


