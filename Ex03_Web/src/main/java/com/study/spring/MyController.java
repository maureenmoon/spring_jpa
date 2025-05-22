package com.study.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MyController {
	
	@RequestMapping("/")
	public @ResponseBody String maureen() {
		return "object model";
	}

//	localhost:8080/maureen?id=100?name=Peter 치면 아래 index.jsp화일 가서 실행결과를 보여줌
	//get방식
	@RequestMapping("/maureen")
	public String index(
			HttpServletRequest httpSletRequest,
			Model model2) {
		String id = httpSletRequest.getParameter("id");
		String name = httpSletRequest.getParameter("name");
		String jumin = httpSletRequest.getParameter("jumin");
		
//		model value 보낼때 사용
		model2.addAttribute("id", id);
		model2.addAttribute("name", name);
		model2.addAttribute("jumin", jumin);
		return "index";
	}
	//parameter 방식
	@RequestMapping("/test1")
	public String test1(
		@RequestParam("id") String id,
		@RequestParam("name") String name,
		@RequestParam("junin") String jumin, Model model
		) {
		model.addAttribute("id", id);
		model.addAttribute("name", name);
		model.addAttribute("junin", jumin);
		return "test1";
	}
	
	//DTO object class
	@RequestMapping("/test2")
	public String test2(Member member, Model model) {
		return "test2";
	}
	
	//http:// 8080/test3/{studentId}/{name}<<<path var방식
	@RequestMapping("/test3/{studentId}/{name}")
	public String test3(
			@PathVariable("studuentId") String studentId,
			@PathVariable("name") String name,
			Model model
			) {
		model.addAttribute("studentId", studentId);
		model.addAttribute("name",name);
		return "test3";
	}
	
	public String test4(
			@PathVariable Member member, Model model
			) {
		model.addAttribute("studentId", member.getId());
		return "test4";
	}
	
	// form:경로명
	@RequestMapping("/form")
	public String form() {
		return "form";
	}
}
