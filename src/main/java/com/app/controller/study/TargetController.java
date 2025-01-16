package com.app.controller.study;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TargetController {
	
	/*
	2) localhost:8080/scopeCheck/first 로 접근 했을 때 위 화면에 나타나도록 하세요.
	accessUrl 은 "/first" 로 지정하세요.
	*/
	
//	@GetMapping("scopeCheck/first")
//	public String first(HttpServletRequest request) {
//		request.setAttribute("accessUrl", "/first");
//		return "/quiz/quiz07/targetPage";
//	}
	
	
	/*
	3) localhost:8080/scopeCheck/firsthide1 로 접근했을때, 위 화면이 나타나도록 하세요.
	accessUrl 은 "/firsthide1" 로 지정하세요.
	*단, 주소창에 url은 /firsthide1로 유지
	*/
	@GetMapping("/scopeCheck/firsthide1")
	public String firsthide1(Model model) {
		model.addAttribute("accessUrl", "/firsthide1");
		return "/quiz/quiz07/targetPage";
	}
	
	/*
	4) localhost:8080/scopeCheck/firsthide2 로 접근했을때, 위 화면이 나타나도록 하세요.
	accessUrl 은 "/first" 로 지정하세요.
	단, 주소창에 url은 /first 로 변경
	*/
//	@GetMapping("/scopeCheck/firsthide2")
//	public String firsthide2() {
//		return "redirect:/scopeCheck/first";
//		//return "redirect:first";
//	}
	
	
	/*
	localhost:8080/SpringProject/firsthide2 로 접근했을때, 위 화면이 나타나도록 하세요.
	accessUrl 은 "/firsthide2" 로 지정하세요.
	단, 주소창에 url은 /first 로 변경
	기존에 /first 로 바로 접속시에 화면에 /first 로 나오는 부분은 유지!!!
	*/
	@GetMapping("/scopeCheck/firsthide2")
	public String firsthide2(HttpSession session) {
		session.setAttribute("accessUrl", "/firsthide2");
		
//		HttpSession session = request.getSession();
//		session.setAttribute("accessUrl", "/firsthide2");
		
		return "redirect:/scopeCheck/first";
	}
	
	@GetMapping("scopeCheck/first")
	public String first(Model model, HttpServletRequest request, HttpSession session) {
		//firsthide2 접근 -> redirect -> session		accessUrl : "/firsthide2"
		
		System.out.println(session.getAttribute("accessUrl"));
		if(session.getAttribute("accessUrl") == null) {	//first로 바로 왔다
			model.addAttribute("accessUrl", "/first");
		} else {	// session accessUrl있다 -> firsthide2를 들렸다가 왔다
			//model.addAttribute("accessUrl", "/firsthire2");
			model.addAttribute("accessUrl", session.getAttribute("accessUrl"));
			session.removeAttribute("accessUrl");
		}
		
		//request scope 삭제 -> session scope 인식
		//session scope -> request scope로 이동 시켜서 request가 자동으로 인식
		
		
		
		/*
		if( session.getAttribute("accessUrl") == null ) {
			request.setAttribute("accessUrl", "/first");
		} else {
			request.setAttribute("accessUrl", "/firsthide2");
			session.invalidate();
		}
		*/
		
		return "/quiz/quiz07/targetPage";
	}
	
}
