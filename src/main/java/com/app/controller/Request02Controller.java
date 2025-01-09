package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/request02")
public class Request02Controller {

	@RequestMapping("url02") // /request02/url02
	public String url02() {
		
		return "url1";
	}
	
	@RequestMapping("url03")
	public String url03() {
		
		return "url1";
	}
	
}
