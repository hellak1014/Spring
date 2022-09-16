package com.springproj.biz.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springproj.biz.board.BoardVO;
import com.springproj.biz.board.service.BoardService;

public class InsertBoardProcController implements Controller {

	@Autowired
	BoardService BoardService;
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//System.out.println("글 등록 화면 처리 작동");
		
		//1. 사용자 입력 정보 추출.
		BoardVO board = new BoardVO(); //boardServiceImpl에서 insertservice를 사용하기 위해서 boardvo를 가져오기.
		
		board.setTitle(request.getParameter("title")); //request에서 값을 꺼내와서 board settertitle에 저장
		board.setWriter(request.getParameter("writer"));
		board.setContent(request.getParameter("content"));
		
		BoardService.insertService(board);
		
		//리스트를 보여주게끔 하면 되는데 getBoardList.do를 만들었기 때문에 이걸 호출해서 돌아가게끔 하면 됨.
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:getBoardList.do");
		
		return mav;
	}

}
