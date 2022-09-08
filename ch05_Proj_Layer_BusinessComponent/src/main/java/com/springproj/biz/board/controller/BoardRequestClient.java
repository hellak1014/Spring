package com.springproj.biz.board.controller;

import com.springproj.biz.board.BoardVO;
import com.springproj.biz.board.service.BoardServiceImpl;

public class BoardRequestClient {

	public static void main(String[] args) {
		
		BoardServiceImpl service = new BoardServiceImpl();
		BoardVO vo = new BoardVO();
		
		vo.setTitle("첫번째 게시글입니다.");
		vo.setWriter("홍길동");
		vo.setContent("홍길동은 개발자.");
		
		service.insertService(vo);
		

	}

}
