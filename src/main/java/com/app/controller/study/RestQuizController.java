package com.app.controller.study;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.dto.user.User;

@Controller
public class RestQuizController {

//	localhost:8080/rest/quiz1 의 경로로 요청하는 경우
	@GetMapping("/rest/quiz1")
	public String quiz1() {
		return "quiz/rest/quiz1";
	}
	
//	localhost:8080/rest/quiz2 의 경로로 요청하는 경우
	@ResponseBody
	@GetMapping("/rest/quiz2")
	public String quiz2() {
		return "return text quiz2";
	}
	
//	localhost:8080/rest/quiz3 의 경로로 요청하는 경우
	@ResponseBody
	@GetMapping("/rest/quiz3")
	public User quiz3() {
		User user = new User();
		user.setId("quizid");
		user.setPw("secret");
		user.setName("quiz이름");
		user.setUserType("CUS");
		
		return user;
	}
	
}
