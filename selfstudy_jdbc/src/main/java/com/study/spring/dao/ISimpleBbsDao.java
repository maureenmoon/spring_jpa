package com.study.spring.dao;

import java.util.List;
import com.study.spring.dto.SimpleBbsDto;

public interface ISimpleBbsDao {
//	crud run only
	
	public int writeDao(String article, String press);
	
	public List<SimpleBbsDto> listDao(int page, int size);
	
	public Integer countDao();
	
	public SimpleBbsDto viewDao(String id);
	
	public int deleteDao(String id);

	public List<SimpleBbsDto> pressDao();


	public int writeDao2(String article, String press);
	public List<SimpleBbsDto> listDao2(int page, int size);
	public Integer countDao2();
	public SimpleBbsDto viewDao2(String id);
	public int deleteDao2(String id);
	public List<SimpleBbsDto> noticeDao();

}
