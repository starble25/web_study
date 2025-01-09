package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {

	@RequestMapping("/faq")
	public String faq() {
		System.out.println("/board/faq 경로로 요청 들어옴");
		return "board/faq";
	}
	
	@GetMapping("/notice")
	public String notice() {
		return "board/notice";
	}
}
