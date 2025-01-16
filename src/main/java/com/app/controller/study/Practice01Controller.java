package com.app.controller.study;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.dto.study.Drink;

@Controller
@RequestMapping("/prac01")
public class Practice01Controller {
	
//	1. /prac01/request1?item=americano&type=coffee 요청 시, 값들 출력 케이스
//	Console창에 println 으로 출력 (사용자 요청을 서버가 읽어서 확인 가능한지)
	
//	1) request 활용 (/request1-1)
	@RequestMapping("/request1-1")
	public String request1_1(HttpServletRequest request) {
		System.out.println(request.getParameter("item"));
		System.out.println(request.getParameter("type"));
		return "/practice/prac01";
	}
	
//	2) RequestParam 활용 (/request1-2)
	@RequestMapping("/request1-2")
	public String request1_2(@RequestParam String item, @RequestParam String type) {
		System.out.println(item);
		System.out.println(type);
		return "/practice/prac01";
	}
	
//	3) RequestParam Map 활용 (/request1-3)
	@RequestMapping("/request1-3")
	public String request1_3(@RequestParam Map<String, String> paramMap) {
		System.out.println(paramMap.get("item"));
		System.out.println(paramMap.get("type"));
		return "/practice/prac01";
	}
	
//	4) 자바 Dto 객체 활용 (/request1-4)
	@RequestMapping("/request1-4")
	public String request1_4(@ModelAttribute Drink drink) {
		System.out.println(drink.getItem());
		System.out.println(drink.getType());
		return "/practice/prac01";
	}
	
//
//	2. /prac01/viewData1 요청시 화면에 값 출력
//	* 화면 전달된 값은 아래와 같이 작성시 출력되어야 함
//	*전달되는 값은 임의로 작성 "넘어간 값"
//	단일
//	${name}
//	${type}
//
//	화면에 객체를 표시할때 사용하는 코드
//	${drinkItem.name}
//	${drinkItem.type}
//
//	1) request 활용 /viewData1-1
	@RequestMapping("/viewData1-1")
	public String viewData1_1(HttpServletRequest request) {
		request.setAttribute("item", "녹차");
		request.setAttribute("type", "tea");
		
		return "/practice/prac01";
	}
	
//	2) Model 활용 /viewData1-2
	@RequestMapping("/viewData1-2")
	public String viewData1_2(Model model) {
		model.addAttribute("item", "홍차");
		model.addAttribute("type", "tea");
		
		return "/practice/prac01";
	}
	
//	3) ModelAndView 활용 /viewData1-3
	@RequestMapping("/viewData1-3")
	public ModelAndView viewData1_3() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("practice/prac01");
		mav.addObject("item", "율무차");
		mav.addObject("type", "tea");
		
		return mav;
	}
	
//	4) Model에 객체 단위로 전달 활용 /viewData1-4
	@RequestMapping("/viewData1-4")
	public String viewData1_4(Model model) {
		Drink drink = new Drink();
		
		drink.setItem("유자차");
		drink.setType("tea");
		
		model.addAttribute("drink", drink);
		
		return "/practice/prac01";
	}
	
}
