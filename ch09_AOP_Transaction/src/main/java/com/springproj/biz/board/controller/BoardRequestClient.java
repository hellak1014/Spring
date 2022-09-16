package com.springproj.biz.board.controller;

import java.util.List;

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
		int seq = 99;
		
		vo.setSeq(seq);  
		vo.setTitle(seq + "번째 게시글"); 
		vo.setWriter("번째 홍길동"); 
		vo.setContent("드디어 나는 개발자.");
		  
		//service.insertService(vo);
		 
		//BoardVO board = service.getService(1);
		//System.out.println(board);
		
		//글 목록 검색 기능
		List<BoardVO> list = service.getServiceList();
		System.out.println("===================================");
		for(BoardVO board : list) {
			System.out.println(board);
			
		}
		
		service.deleteService(14);
		
		factory.close();
	}
	
	

}
