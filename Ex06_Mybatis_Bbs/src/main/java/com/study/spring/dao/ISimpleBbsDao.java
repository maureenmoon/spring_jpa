package com.study.spring.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.study.spring.dto.SimpleBbsDto;

@Mapper
public interface ISimpleBbsDao {
	//write - int
	public int writeDao(String writer, String subject, String contentID, String imageUrl, String description);

	//list - List<SimpleBbsDto>
//	public List<SimpleBbsDto> listDao()<=write
	public List<SimpleBbsDto> listDao(@Param("size") int size,@Param("offset") int offset);

    //count - Integer(null이 나오면 안됨, 래퍼클래스)
	public Integer countDao();


	//view - SimpleBbsDto 
	public SimpleBbsDto viewDao(String id);
	//select * from simple_bbs where id = #{0}


	//delete - int
	public int deleteDao(String id);


}
