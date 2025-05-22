package com.study.spring.service;

import java.util.List;
import java.util.Map;

public interface ISimpleBbsService {

	void write(String writer, String subject, String contentID, String imageUrl, String description);
	int count();
	Object view(String sId);
	void delete(String parameter);
	Map<String, Object> getPageList(int page, int size);

}
