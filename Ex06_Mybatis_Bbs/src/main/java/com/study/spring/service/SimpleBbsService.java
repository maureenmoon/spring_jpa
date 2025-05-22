package com.study.spring.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.study.spring.dao.ISimpleBbsDao;
import com.study.spring.dto.SimpleBbsDto;

@Service
public class SimpleBbsService implements ISimpleBbsService{
	
	@Autowired
	ISimpleBbsDao dao;

	@Override
	public void write(String writer, String subject, String contentID, String imageUrl, String description) {
		dao.writeDao(writer, subject, contentID, imageUrl, description);
	}

	@Override
	public int count() {
		return dao.countDao();
	}

	@Override
	public Object view(String sId) {	
		return dao.viewDao(sId);
	}

	@Override
	public void delete(String parameter) {
		dao.deleteDao(parameter);
	}

	@Override
	public Map<String, Object> getPageList(int page, int size) {
		int totalCount = dao.countDao();	
		int totalPages = (int)Math.ceil((double) totalCount / size);
		int offset = ( page - 1) * size;
		List<SimpleBbsDto> list = dao.listDao(size, offset);
		
		Map<String, Object> result = new HashMap<>();
		
		result.put("lists", list);
		result.put("totalCount", totalCount);
		result.put("totalPages", totalPages);
		result.put("currentPage", page);
		result.put("size", size);
		
		return result;
	}

}
