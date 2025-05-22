package com.study.spring.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.study.spring.dao.ISimpleBbsDao;
import com.study.spring.dto.SimpleBbsDto;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MyController {

//	crud:create(/list) read/update(/write) delete(/delete)
	
	@Autowired
	ISimpleBbsDao dao;

//	진로 변경시마다 method 만들어야함: /, /write, /list
	@RequestMapping("/")
	public String root() {
		return "index";
	}

//	문서 받는 form 필요
	@RequestMapping("/writeForm")
	public String writeForm() {
		return "bbs/writeForm";
	}

//	write 실행하는곳
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		dao.writeDao(writer, title, content);
		System.out.println(writer + title + content);
		return "redirect:list";
	}
//	<READ>http://localhost:8080/view?page=2&size=10
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model) {
		
		String pageParam = request.getParameter("page");
		String sizeParam = request.getParameter("size");
		
//		object인  request는 String인데 int로 변경<=unboxing
		int page = (pageParam != null && !pageParam.isEmpty()) ? Integer.parseInt(pageParam) : 1;
		int size = (sizeParam != null && !sizeParam.isEmpty()) ? Integer.parseInt(sizeParam) : 5;
		
		int totalCount = dao.countDao();
		
		int totalPages = (int)Math.ceil((double)totalCount/size);
		
		List<SimpleBbsDto> list = dao.listDao(page,size);

		model.addAttribute("lists", list);
		
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("totalPages",totalPages);
		model.addAttribute("currentPage",page);
		model.addAttribute("size",size);
		
		return "bbs/list";
	}

//	http://localhost:8080/view?id=1
	@RequestMapping("/view")
	public String view(HttpServletRequest request, Model model) {
		String sId = request.getParameter("id");
		model.addAttribute("dto", dao.viewDao(sId));

		return "bbs/view";
	}

//	http://localhost:8080/delete?id=1
	@RequestMapping("/delete")
	public String Delete(HttpServletRequest request) {
		dao.deleteDao(request.getParameter("id"));
		return "redirect:list";
	}
}
