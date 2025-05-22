package com.study.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	
	@Autowired
	MyDAO listDao2;
	
	@RequestMapping("/")
	public @ResponseBody String root() {
		return "jdbc template";
	}
	
//	db shown into screen
// Model ui
	@RequestMapping("/index")
	public String index(Model model) {
//	create list DAO
		model.addAttribute("lists", listDao2.list());
		// 속성을 추가. listDao2리스트형식으로 담아 lists에 옮김
		return "index";
		// jsp와 연결

}
}
