package com.app.controller.study;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
//	================================================
//	1)
//	localhost:8080/quiz/req1 경로에 GET 메소드로 요청한 경우
//	"/quiz/req1 GET 요청" 출력
	@GetMapping("/req1")
	public String req1Get() {
		System.out.println("/quiz/req1 GET 요청");
		return "quiz/main";
	}
//
//	2)
//	localhost:8080/quiz/req1 경로에 POST 메소드로 요청한 경우
//	"/quiz/req1 POST 요청" 출력
	@PostMapping("/req1")
	public String req1Post() {
		System.out.println("/quiz/req1 POST 요청");
		return "quiz/main";
	}
//
//	3) 위 두가지 경우가 실행되도록 요청을 발생시키시요.
//	(선택 : view 코드를 작성하여 요청 or PostMan 활용)
//
//	4)
//	localhost:8080/quiz/req2 경로로 요청하면서 data1, data2 라는 파라미터를 전달하시오.
//	- GET 방식 POST 방식 상관 없이 모두 수행가능
//	- 요청시 "/quiz/req2 요청" 출력
//	- data1과 data2 이름으로 들어온 파라미터 값도 출력
//	- 위 출력이 나타나도록
//	GET방식과 POST방식으로 각각 data1과 data2 파라미터와 함께 요청을 발생시키시요.
//	(선택 : view 코드를 작성하여 요청 or PostMan 활용)
	@RequestMapping("/req2")
	public String req2(HttpServletRequest request) {
		System.out.println("== req2 ==");
		System.out.println(request.getParameter("data1"));
		System.out.println(request.getParameter("data2"));
		
		request.setAttribute("data1", request.getParameter("data1"));
		request.setAttribute("data2", request.getParameter("data2"));
		return "quiz/main";
	}
	
}
