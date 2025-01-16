package com.app.controller.study;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.dto.study.Product;

@Controller
public class ViewDataController {

	@GetMapping("/viewData1")
	public String viewData1(HttpServletRequest request) {
		
		System.out.println(request.getParameter("p1"));
		
		request.setAttribute("state", "배가 고프다");
		request.setAttribute("time", "점심시간");
		
		return "viewData/viewData1";
	}
	
	@GetMapping("/viewData2")
	public String viewData2(Model model) {
		model.addAttribute("state", "배가 더 고프다");
		model.addAttribute("time", "12분남음");
		
		return "viewData/viewData1";
	}
	
	@GetMapping("/viewData3")
	public ModelAndView viewDate3() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("viewData/viewData1");
		mav.addObject("state", "죽기직전");
		mav.addObject("time", "5분전");
		
		return mav;
	}
	
	@GetMapping("/viewData4")
	public ModelAndView viewDate4(ModelAndView mav) {
		
		mav.setViewName("viewData/viewData1");
		mav.addObject("state", "여유롭다");
		mav.addObject("time", "점심지남");
		
		return mav;
	}
	
	@GetMapping("/viewDate5")
	public String viewData5(Model model) {
		
		model.addAttribute("msg", "집에 가고싶다");
		
		Product product = new Product();
		product.setId("idii");
		product.setName("namenn");
		product.setPrice(19900);
		model.addAttribute("product", product);
		
		return "viewData/viewData5";
	}
	
	@GetMapping("/viewDate6")
//	public String viewData6(Model model, HttpServletRequest request) {
//		request.getParameter("searchKeyword")
	public String viewData6(Model model, @RequestParam(required = false) String searchKeyword) {
//	public String viewData6(Model model, @RequestParam Map<String, String> paramMap) {
//		paramMap.get("searchKeyword");
		
		System.out.println(searchKeyword);
		
		model.addAttribute("searchKeyword", searchKeyword);
		
		// searchKeyword -> DB Query 조회 -> 결과
		
		/*
		try {
			if(searchKeyword.equals("커피")) {
				Product product = new Product();
				product.setId("001");
				product.setName("아메리카노");
				product.setPrice(1500);
				
				model.addAttribute("product", product);
			}
			
			if(searchKeyword.equals("차")) {
				Product product = new Product();
				product.setId("tea");
				product.setName("민트티");
				product.setPrice(3500);
				
				model.addAttribute("product", product);
			}
		} catch (Exception e) {
			//예외처리
		}*/
		
		if(searchKeyword != null) {
		
			if(searchKeyword.equals("커피")) {
				Product product = new Product();
				product.setId("001");
				product.setName("아메리카노");
				product.setPrice(1500);
				
				model.addAttribute("product", product);
			}
			
			if(searchKeyword.equals("차")) {
				Product product = new Product();
				product.setId("tea");
				product.setName("민트티");
				product.setPrice(3500);
				
				model.addAttribute("product", product);
			}
		}
		
		return "viewData/viewData5";
	}
	
}
