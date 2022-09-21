package com.springproj.biz.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice("com.springproj.controller") // 예외처리 할때 쓰는 annotation. 객체 생성해주라.
public class commonExceptionHandler {

	@ExceptionHandler(ArithmeticException.class)
	public ModelAndView handleArithmeticException(Exception e) {

		ModelAndView mav = new ModelAndView();

		mav.addObject("exception", e);
		mav.setViewName("/common/arithmeticError");

		return mav;

	}

	@ExceptionHandler(NullPointerException.class)
	public ModelAndView handleNullPointerException(Exception e) {

		ModelAndView mav = new ModelAndView();

		mav.addObject("exception", e);
		mav.setViewName("/common/nullPointerError");

		return mav;

	}

	
	  @ExceptionHandler(Exception.class) public ModelAndView
	  handleException(Exception e){
	  
	  ModelAndView mav = new ModelAndView();
	 
	  mav.addObject("exception", e); mav.setViewName("/common/error");
	  
	  return mav;
	  
	  }
	

}
