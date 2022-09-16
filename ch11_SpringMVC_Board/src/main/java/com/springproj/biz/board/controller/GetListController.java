package com.springproj.biz.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springproj.biz.board.BoardVO;
import com.springproj.biz.board.service.BoardService;

public class GetListController implements Controller {

	@Autowired //객체 주입해주라 (Impl에 service된 객체)
	BoardService boardService;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("글 목록 검색 처리");
		
		//참조변수로 getServiceList 불러오기. 
		
		List<BoardVO> list = boardService.getServiceList();
		
		ModelAndView mav = new ModelAndView(); //모델뷰를 이용하기 위한 참조변수 형성
		mav.addObject("boardList", list); //mav에 넣어 보낼 데이터 넣기. 
		mav.setViewName("getBoardList"); //어떤 곳으로 보낼지 페이지 지정. Resolver가 있는 위치 + 확장자 붙여줌
		
		return mav;
	}

}
