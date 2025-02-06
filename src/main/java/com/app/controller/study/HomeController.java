package com.app.controller.study;

import org.springframework.stereotype.Controller;

@Controller
public class HomeController {

//	@RequestMapping("/")
	public String home() {
		//return "/WEB-INF/views/home.jsp";
		//return "/WEB-INF/views/mainpage.jsp";
		
		//--ViewResolver 설정 이후
		return "home";
	}
}