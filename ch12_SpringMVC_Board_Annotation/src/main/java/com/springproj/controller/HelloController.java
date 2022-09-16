package com.springproj.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller{
	//디스패쳐 서블릿이 핸들러 매핑에게 물어봄. 핸들러 매핑이 자료형 안에 handleRequest를 호출하게 한다.  
	
	//추상매서드 호출
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//System.out.println("/hello.do 요청 처리 매서드");
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("greeting", "Hello Spring"); //mav를 객체에 담아준다. 
		mav.setViewName("hello");  // viewresolver를 거치면 /WEB-INF/views/hello.jsp 라는 화면을 만들어주면 뷰가 저 파일을 꺼내온다. 
									// viewresolver는 가는 길을 만들어주는 역할. servlet-context 가면 있음. 
		
		return mav; //모델과 뷰의 인터페이스 가교역할. 여기서 나온 modelview를 리턴값으로 둠. 디스패쳐 서블릿으로 값을 준다.
		
		//2번, 3번을 처리. 
	}
	
	

}
