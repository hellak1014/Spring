package com.springproj.biz.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproj.biz.board.BoardVO;
import com.springproj.biz.board.dao.BoardDAO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO dao;
	//@Autowired
	//private LogAdvice log;
	//private LogAdvice log;
	
	
	
	@Override
	public void insertService(BoardVO vo) {
		//log.printLogging("> insertService() <");
		/* log.printLogging("= insertService() ="); */
		dao.insertBoard(vo);
	}

	@Override
	public void getService(int seq) {
		//log.printLogging("> getService() <");
		/* log.printLogging("= getService() ="); */
		dao.getBoard(seq);
		
	}

	@Override
	public void getServiceList() {
		//log.printLogging("> getServiceList() <");
		//log.printLogging("= getServiceList() =");
		dao.getBoardList();
		
	}

	@Override
	public void updateService(BoardVO vo) {
		//log.printLogging("> updateService() <");
		//log.printLogging("= updateService() =");
		dao.updateBoard(vo);
		
	}

	@Override
	public void deleteService(int seq) {
		//log.printLogging("> deleteService() <");
		//log.printLogging("= deleteService() =");
		dao.deleteBoard(seq);
		
	}
	
}
