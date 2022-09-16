package com.springproj.biz.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springproj.biz.board.BoardVO;
import com.springproj.biz.board.service.BoardService;

public class GetBoardController implements Controller {
	@Autowired
	BoardService boardService; 
	// getService를 받아오기 위해서 BoardServiceImpl를 가져와야 함. 근데 BoardServiceImpl는 BoardService를 상속해온 관계이기 때문에
	// 약한 연결성을 위해서는 BoardServiceImpl가 아닌 BoardService를 가져와야 한다. annotation으로 객체가 생성 되어있기 때문에
	// 생성된 객체를 가져오는 autowired를 사용. 
	
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//System.out.println("GetBoardController 처리.");
		
		String seq = request.getParameter("seq"); //getBoardList에서 넘긴 seq를 받아주기.
		
		BoardVO board = boardService.getService(Integer.parseInt(seq));	//String으로 온 seq를 int로 변환.  
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("board", board);
		mav.setViewName("getBoard");
		
		return mav;
	}

}
