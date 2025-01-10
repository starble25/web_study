package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/quiz")
public class QuizController {

	@RequestMapping("/main")
	public String quizMain() {
		return "quiz/main";
	}
	
//	@RequestMapping(value="/product/mouse", method = RequestMethod.GET)
	@RequestMapping("/product/mouse")
	public String quizMouse() {
		return "quiz/product/mouse";
//		return "quiz/mouse";
	}
	
//	@GetMapping("/product/keyboard")
	@RequestMapping("/product/keyboard")
	public String quizKeyboard() {
		return "quiz/product/keyboard";
	}
}
