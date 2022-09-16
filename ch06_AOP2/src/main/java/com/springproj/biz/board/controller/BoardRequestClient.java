package com.springproj.biz.board.controller;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.springproj.biz.board.BoardVO;
import com.springproj.biz.board.service.BoardService;

public class BoardRequestClient {

	public static void main(String[] args) {
		AbstractApplicationContext factory
			= new GenericXmlApplicationContext("applicationContext.xml");
		
		BoardService service
			=(BoardService)factory.getBean("boardService");
		
		//BoardServiceImpl service = new BoardServiceImpl(); 
		BoardVO vo = new  BoardVO();
		  
		vo.setTitle("첫번째 게시글"); 
		vo.setWriter("홍길동"); 
		vo.setContent("드디어 나는 개발자.");
		  
		service.insertService(vo);
		 
		BoardVO board = service.getService(1);

		System.out.println(board);
		
		factory.close();
	}

}
