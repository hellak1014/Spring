package com.springproj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.springproj.biz.domain.UserVO;

@Controller //bean생성해줘라
public class LogInOutController { //자료형 정의

	@GetMapping(value = "/login.me")
	public String loginForm() {
		//System.out.println("loginForm() 호출");
		
		return "login";
	}
	
	@PostMapping(value = "/login.me")
	public String loginProc(UserVO user) {
		//System.out.println("loginProc() 호출");
		
		//1. user의 id 존재 여부를 db에서 가져오기. 
		
		return "redirect:getBoardList.do";
	}
	
}
