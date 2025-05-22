package com.study.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	@RequestMapping("/")
	public @ResponseBody String root() {
		return "lombok annotation usage";
	}
	@RequestMapping("/test1")
	public String test(Member member, Model model) {
		System.out.println(member);
		return "test1";
	}
}
