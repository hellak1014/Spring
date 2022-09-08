package com.springproj.biz.board.controller;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.springproj.biz.board.BoardVO;
import com.springproj.biz.board.service.BoardService;

public class BoardRequestClient {

	public static void main(String[] args) {
		
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		BoardService service = 
					(BoardService)factory.getBean("boardService");
		
		/* BoardServiceImpl service = new BoardServiceImpl(); */
		BoardVO vo = new BoardVO();
		
		vo.setTitle("첫번째 게시글입니다.");
		vo.setWriter("홍길동");
		vo.setContent("홍길동은 개발자.");
		
		service.insertService(vo);
		
		factory.close();
		

	}

}
