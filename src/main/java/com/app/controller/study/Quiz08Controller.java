package com.app.controller.study;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Quiz08Controller {

	@GetMapping("/quiz/session/login")
	public String login() {
		
		return "/quiz/quiz08/login";
	}
	
	@PostMapping("/quiz/session/login")
	public String loginAction(HttpServletRequest request) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		//id pw <-> 데이터 비교 <-> 정상인지 체크
		HttpSession session = request.getSession();
		
		//로그인 성공이라고 간주
		//session.setAttribute("isLogin", true);
		session.setAttribute("loginId", id);
		session.setAttribute("count", 0);
		
		//로그인 후 -> 내가 쓴 게시글
		//DB조회
		return "redirect:/quiz/session/count";
	}
	
	@GetMapping("/quiz/session/count")
	public String count(HttpSession session, Model model) {
		
		//로그인 한 상태면 count 증가
		if( session.getAttribute("loginId") != null ) {
			int count = (Integer)session.getAttribute("count") + 1;
			session.setAttribute("count", count);
		} else {
			model.addAttribute("count", 0);
		}
		
		return "/quiz/quiz08/count";
	}
	
	@GetMapping("/quiz/session/logout")
	public String logout(HttpSession session) {
		//세션에 저장된 정보 삭제
		//session.removeAttribute("loginId");
		//session.removeAttribute("count");
		
		//초기화
		session.invalidate();
		
		return "redirect:/quiz/session/count";
	}
	
	
}

//3개의 접속 경로를 통해서 세션 범위에 값을 저장해두면, 계속 접속 정보가 남아있는 것을 확인해보고자 한다.
//
//경로 1) /quiz/session/login
//GET방식 접속 : ID와 PW를 입력하는 화면이 발생됨
//POST방식 접속 : 입력한 ID와 PW를 확인하여 정상인경우로 간주하고,
//세션에 해당 ID를 로그인한 아이디로 저장하고 /quiz/session/count 페이지로 이동시킨다.
//

//경로 2) /quiz/session/count
//화면에는 어떤 사용자가 로그인한 상태인지 "사용자 아이디"가 표시되며,
//해당 사용자가 로그인한 이후, 현재 페이지에 몇번 접속했는지의 횟수가 함께 화면에 표시됨.
//> 해당 사이트에 여러번 접속하면, 접속 할때마다 해당 count가 증가한다.
//(로그아웃 전까지는 접속할 때 마다 count 값이 계속 증가해야한다)
//> 만약, 로그인을 통해 어떤 사용자가 로그인 했다는 이력이 없는 경우에는 횟수는 0으로 표기.
//

//경로 3) /quiz/session/logout
//위 경로로 접근 시, 세션에 저장되어있는 기록을 삭제하고 로그인한 이력이 없는것으로 만든다.
//이후, /quiz/session/count 페이지로 이동 시킨다