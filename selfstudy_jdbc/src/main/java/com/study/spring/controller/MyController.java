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
	
	//need to create a method per each root: /, /write, /list
	@RequestMapping("/")
	public String root(Model model) {
		List<SimpleBbsDto> press = dao.pressDao();	
		model.addAttribute("pressLists",press);
		List<SimpleBbsDto> notice = dao.noticeDao();	
		model.addAttribute("noticeLists",notice);
		return "index";
	}
	// read Form
	@RequestMapping("/about")
	public String about() {
		return "subpage/about";
	}	
	// read Form
	@RequestMapping("/writeForm")
	public String writeForm() {
		return "bbs/writeForm";
	}
	// read
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		String article = request.getParameter("article");
		String press = request.getParameter("press");
		String content = request.getParameter("content");
		
		dao.writeDao(article, press);
		System.out.println(article+press);
		return "redirect:list";
	}
//	<READ>http://localhost:8080/view?page=2&size=10	
	@RequestMapping("/list")
	public String list(HttpServletRequest request,Model model){
		String pageParam = request.getParameter("page");
		String sizeParam = request.getParameter("size");		
//		object인  request는 String인데 int로 변경필요<=unboxing
		int page = (pageParam != null && !pageParam.isEmpty()) ? Integer.parseInt(pageParam) : 1;
		int size = (sizeParam != null && !sizeParam.isEmpty()) ? Integer.parseInt(sizeParam) : 3;		
		int totalCount = dao.countDao();
		int totalPages = (int)Math.ceil((double)totalCount/size);		
//		System.out.println(page+"/" + size +"/" +totalCount +"/" +totalPages);
		List<SimpleBbsDto> list = dao.listDao(page, size);	
		model.addAttribute("lists",list);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("currentPage", page);		
		model.addAttribute("size", size);
		
		return "bbs/list";
	}
//	http://localhost:8080/view?id=1
	@RequestMapping("/view")
	public String view(HttpServletRequest request, Model model){
			String sId = request.getParameter("id");
			model.addAttribute("dto", dao.viewDao(sId)
			);
			return "bbs/view";
	}
//	http://localhost:8080/delete?id=1
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) {
			dao.deleteDao(request.getParameter("id")
			);
			return "redirect:list";
			}
	// read Form
	@RequestMapping("/writeForm2")
	public String writeForm2() {
		return "bbs/writeForm2";
	}
	// read
	@RequestMapping("/write2")
	public String write2(HttpServletRequest request, Model model) {
		String article = request.getParameter("article");
		String press = request.getParameter("press");
		
		dao.writeDao2(article, press);
		System.out.println(article+press);
		return "redirect:list2";
	}
//	<READ>http://localhost:8080/view?page=2&size=10	
	@RequestMapping("/list2")
	public String list2(HttpServletRequest request,Model model){
		String pageParam = request.getParameter("page");
		String sizeParam = request.getParameter("size");		
//		object인  request는 String인데 int로 변경필요<=unboxing
		int page = (pageParam != null && !pageParam.isEmpty()) ? Integer.parseInt(pageParam) : 1;
		int size = (sizeParam != null && !sizeParam.isEmpty()) ? Integer.parseInt(sizeParam) : 3;		
		int totalCount = dao.countDao2();
		int totalPages = (int)Math.ceil((double)totalCount/size);		
//		System.out.println(page+"/" + size +"/" +totalCount +"/" +totalPages);
		List<SimpleBbsDto> list = dao.listDao2(page, size);	
		model.addAttribute("lists",list);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("currentPage", page);		
		model.addAttribute("size", size);
		
		return "bbs/list2";
	}
//	http://localhost:8080/view?id=1
	@RequestMapping("/view2")
	public String view2(HttpServletRequest request, Model model){
		String sId = request.getParameter("id");
		model.addAttribute("dto", dao.viewDao2(sId)
				);
		return "bbs/view2";
	}
//	http://localhost:8080/delete?id=1
	@RequestMapping("/delete2")
	public String delete2(HttpServletRequest request) {
			dao.deleteDao2(request.getParameter("id")
			);
			return "redirect:list2";
			}
	}