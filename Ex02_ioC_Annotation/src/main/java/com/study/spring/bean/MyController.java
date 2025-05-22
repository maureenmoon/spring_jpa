package com.study.spring.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	@Autowired
	Member member1;
	
	@Autowired
	@Qualifier("printerB")
	Printer printer1;
	
	@Autowired
	Member member2;
	
	@RequestMapping("/")
	public @ResponseBody String screenout() {
		member1.print();
		member1.setPrinter(printer1);
		member1.setName("Hong");
		member1.setNickname("Bigdosa");
		member1.print();
		return "test spring boot";
	}

	@RequestMapping("/test")
	public @ResponseBody String screenout2() {
		member2.print();
		return "test view";
	}
}
