package com.study.spring.dao;


import java.util.List;
import com.study.spring.dto.SimpleBbsDto;

public interface ISimpleBbsDao {
//	@Autowired
//	JdbcTemplate template;
	
	//실행부만 여기에 있음. 부모단(SimpleBbsDao)에 구현부있음
	//write - int: 입력하는 것은 0,1뿐이라 int type사용가능
	public int writeDao(String writer, String title, String content) ;

	
	//list - list<SimpletBbsDto>
	public List<SimpleBbsDto> listDao(int page, int size);
	//	collection framework: collect objects in array type

	//count -integer(null)나오면 안됨. wrapper class. not 100% object
	public Integer countDao();


	//view - String
	public SimpleBbsDto viewDao(String id);
	
	//delete - int
	public int deleteDao(String id);


}
