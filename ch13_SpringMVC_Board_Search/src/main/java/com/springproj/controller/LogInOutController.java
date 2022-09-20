package com.springproj.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springproj.biz.domain.UserVO;
import com.springproj.biz.service.UserService;

@Controller //bean생성해줘라
public class LogInOutController { //자료형 정의
	@Autowired
	UserService userService;

	@GetMapping(value = "/login.me")
	public String loginForm(@ModelAttribute("usr") UserVO vo) { //커맨드 객체가 물고온 객체. jsp에서 그대로 사용 가능.
		//파라미터 이름을 지정하는 @ModelAttribute annotation
		//System.out.println("loginForm() 호출");
		
		vo.setId("test");
		vo.setPassword("test1234"); 
		
		return "login";
	}
	
	@PostMapping(value = "/login.me")
	public String loginProc(UserVO user, HttpSession session) {
		//System.out.println("loginProc() 호출");
		String retVal = null; //리턴값을 저장할 변수
		
		//1. user의 id 존재 여부를 db에서 가져오기. 
		
		UserVO vo = userService.getService(user); //db에서 가져온 자료를 vo라는 참조변수로 지정. 
		
		if((vo != null) && 
				vo.getPassword().equals(user.getPassword())) { //로그인 성공시
			
			session.setAttribute("userName", vo.getName()); //세션 생성. 
			retVal = "redirect:getBoardList.do";
			
		} else	{												//로그인 실패시
			retVal = "redirect:login.me";
	}
		return retVal;
	
	}
	
	@RequestMapping("logout.me")
	public String logoutProc(HttpSession session) {
		System.out.println("로그아웃 처리");
		
		session.invalidate(); //세션 삭제
		
		return "redirect:login.me";
	}
	
}
