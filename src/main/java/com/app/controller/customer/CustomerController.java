package com.app.controller.customer;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.common.CommonCode;
import com.app.dto.user.User;
import com.app.service.user.UserService;
import com.app.util.LoginManager;

@Controller
public class CustomerController {
	
	@Autowired
	UserService userService;
	
	//회원가입
	@GetMapping("/customer/signup")
	public String signup() {
		return "customer/signup";
	}
	
	@PostMapping("/customer/signup")
	public String signUpAction(User user) {
		
		user.setUserType(CommonCode.USER_USERTYPE_CUSTOMER);
		int result = userService.saveUser(user);
		
		if( result > 0 ) {
			return "main"; 
		} else {
			return "customer/signup";
		}
	}
	
	@GetMapping("/customer/login")
	public String login() {
		return "customer/login";
	}
	
	@PostMapping("/customer/login")
	public String loginAction(User user, HttpSession session) {
		
		//user	id, pw 화면으로부터 전달
		// name, userType : null
		
		//user 로그인 할 수 있게 정보가 들어있는지 확인
		user.setUserType(CommonCode.USER_USERTYPE_CUSTOMER);
		User loginUser = userService.checkUserLogin(user);
		
		if( loginUser == null ) {
			return "customer/login";
		} else {
			//로그인 정보가 맞아서 로그인 성공
			//session.setAttribute("loginUser", loginUser);
			//session.setAttribute("loginUserId", loginUser.getId());
			LoginManager.setSessionLogin(session, loginUser.getId());
			
			return "redirect:/main";
		}
	}
	
	@GetMapping("customer/logout")
	public String logout(HttpSession session) {
		//session.invalidate();
		LoginManager.logout(session);
		
		return "redirect:/main";
	}
	
	@GetMapping("/customer/mypage")
	public String mypage(HttpSession session, Model model) {
		
		//session에 loginUserId 값의 존재유무
		//if( session.getAttribute("loginUserId") != null ) {
		if( LoginManager.isLogin(session) ) {
			//로그인 되어 있는 정보를 보여주기
			//User user = userService.findUserById((String) session.getAttribute("loginUserId"));
			User user = userService.findUserById(LoginManager.getLoginUserId(session));
			model.addAttribute("user", user);
			
			return "customer/mypage";
		} else {
			return "redirect:/customer/login";
		}
	}
	
}
