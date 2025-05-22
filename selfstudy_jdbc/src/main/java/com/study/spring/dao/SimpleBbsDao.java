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
	public int writeDao(String article, String press) {
		System.out.println("---------writeDao run------");
		String query = "insert into web_lg (article, press) values ( ?, ?)";
		
		return template.update(query, article, press);
	}

	@Override
	public List<SimpleBbsDto> listDao(int page, int size) {
		System.out.println("--------listDao run---------");
		int offset = (page-1)*size;
		String query = "select * from web_lg order by id desc limit ? offset ?";
		List<SimpleBbsDto> list = template.query(query,new BeanPropertyRowMapper<>(SimpleBbsDto.class), size, offset);
		return list;
	}

	@Override
	public Integer countDao() {
		System.out.println("--------countDao run---------");
		String query = "select count(*) from web_lg";
		Integer count = template.queryForObject(query, Integer.class);
		return count;
	}

	@Override
	public SimpleBbsDto viewDao(String id) {
		System.out.println("--------viewDao run---------");
		String query = "select * from web_lg where id= " + id;
		SimpleBbsDto view = template.queryForObject(query, new BeanPropertyRowMapper<>(SimpleBbsDto.class)
				);
		return view;
	}

	@Override
	public int deleteDao(String id) {
		System.out.println("--------deleteDao run---------");
		String query = "delete from web_lg where id = ?";
		return template.update(query, Integer.parseInt(id));
	}

	@Override
	public List<SimpleBbsDto> pressDao() {
		String query = "select * from web_lg order by id desc limit 3";
		List<SimpleBbsDto> press = template.query(query,new BeanPropertyRowMapper<>(SimpleBbsDto.class));
		return press;
	}
//	2nd 게시판
	@Override
	public int writeDao2(String article, String press) {
		System.out.println("---------writeDao2 run------");
		String query = "insert into lg_notice (article, press) values ( ?, ?)";
		
		return template.update(query, article, press);
	}

	@Override
	public List<SimpleBbsDto> listDao2(int page, int size) {
		System.out.println("--------listDao2 run---------");
		int offset = (page-1)*size;
		String query = "select * from lg_notice order by id desc limit ? offset ?";
		List<SimpleBbsDto> list2 = template.query(query,new BeanPropertyRowMapper<>(SimpleBbsDto.class), size, offset);
		return list2;
	}
	@Override
	public Integer countDao2() {
		System.out.println("--------countDao2 run---------");
		String query = "select count(*) from lg_notice";
		Integer count = template.queryForObject(query, Integer.class);
		return count;
	}
	@Override
	public SimpleBbsDto viewDao2(String id) {
		System.out.println("--------viewDao2 run---------");
		String query = "select * from lg_notice where id= " + id;
		SimpleBbsDto view2 = template.queryForObject(query, new BeanPropertyRowMapper<>(SimpleBbsDto.class)
				);
		return view2;
	}
	@Override
	public List<SimpleBbsDto> noticeDao() {
		String query = "select * from lg_notice order by id desc limit 3";
		List<SimpleBbsDto> notice = template.query(query,new BeanPropertyRowMapper<>(SimpleBbsDto.class));
		return notice;
	}
	@Override
	public int deleteDao2(String id) {
		System.out.println("--------deleteDao2 run---------");
		String query = "delete from lg_notice  where id = ?";
		return template.update(query, Integer.parseInt(id));
	}
}
