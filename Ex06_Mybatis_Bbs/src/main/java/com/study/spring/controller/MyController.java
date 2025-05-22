package com.study.spring.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.spring.dao.ISimpleBbsDao;
import com.study.spring.dto.SimpleBbsDto;
import com.study.spring.service.ISimpleBbsService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MyController {
	
	@Autowired
	ISimpleBbsService bbsService;
	
	@RequestMapping("/")
	public String root() {
		return "index";
	}
	@RequestMapping("/writeForm")
	public String writeForm() {
		return "bbs/writeForm";
	}
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		String writer = request.getParameter("writer");
		String subject = request.getParameter("subject");
		String contentID = request.getParameter("contentID");
		String imageUrl = request.getParameter("imageUrl");	
		String description = request.getParameter("description");	
		bbsService.write(writer, subject, contentID, imageUrl, description);
		System.out.println(writer + subject + contentID + imageUrl + description);
		return "redirect:list";
	}		
	//localhost:8080/list?page=2&size=10
	@RequestMapping("/list")
	public String list(
			HttpServletRequest request,
			Model model) {		
		String pageParam = request.getParameter("page");
		String sizeParam = request.getParameter("size");		
		int page = (pageParam != null && !pageParam.isEmpty() ) ? Integer.parseInt(pageParam):1; 
		int size = (sizeParam != null && !sizeParam.isEmpty() ) ? Integer.parseInt(sizeParam):5;		
		Map<String, Object> result = bbsService.getPageList(page,size);
//		key(String) & Value(Object)	
		model.addAllAttributes(result);				
		return "bbs/list";
	}	
	// http://localhost:8080/view?id=1
	@RequestMapping("/view")
	public String view(
			HttpServletRequest request,
			Model model
			) {
		String sId = request.getParameter("id");
		model.addAttribute("dto",bbsService.view(sId));	
		return "bbs/view";
	}
	
	// http://localhost:8080/delete?id=1
	@RequestMapping("/delete")
	public String Delete(
			HttpServletRequest request
			) {
		bbsService.delete(request.getParameter("id"));
		return "redirect:list";
	}
	@RequestMapping("/login")
	public String LoginPage() {
		return "member/loginForm";
	}
}