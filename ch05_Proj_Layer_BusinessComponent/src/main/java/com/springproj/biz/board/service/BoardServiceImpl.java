package com.springproj.biz.board.service;

import com.springproj.biz.board.BoardVO;
import com.springproj.biz.board.dao.BoardDAO;

public class BoardServiceImpl implements BoardService {
	
	private BoardDAO dao;
	
	public BoardServiceImpl() {
		dao = new BoardDAO();
	}
	
	@Override
	public void insertService(BoardVO vo) {
		
		dao.insertBoard(vo);
	}

	@Override
	public void getService(int seq) {
		dao.getBoard(seq);
		
	}

	@Override
	public void getServiceList() {
		dao.getBoardList();
		
	}

	@Override
	public void updateService(BoardVO vo) {
		dao.updateBoard(vo);
		
	}

	@Override
	public void deleteService(int seq) {
		dao.deleteBoard(seq);
		
	}
	
}
