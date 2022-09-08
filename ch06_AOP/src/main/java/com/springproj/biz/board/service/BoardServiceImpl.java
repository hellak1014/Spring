package com.springproj.biz.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproj.biz.board.BoardVO;
import com.springproj.biz.board.dao.BoardDAO;
import com.springproj.biz.common.LogAdvice;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO dao;
	@Autowired
	//private LogAdvice log;
	private LogAdvice log;
	
	
	
	@Override
	public void insertService(BoardVO vo) {
		log.printLog("> insertService() <");
		/* log.printLogging("= insertService() ="); */
		dao.insertBoard(vo);
	}

	@Override
	public void getService(int seq) {
		log.printLog("> getService() <");
		/* log.printLogging("= getService() ="); */
		dao.getBoard(seq);
		
	}

	@Override
	public void getServiceList() {
		log.printLog("> getServiceList() <");
		//log.printLogging("= getServiceList() =");
		dao.getBoardList();
		
	}

	@Override
	public void updateService(BoardVO vo) {
		log.printLog("> updateService() <");
		//log.printLogging("= updateService() =");
		dao.updateBoard(vo);
		
	}

	@Override
	public void deleteService(int seq) {
		log.printLog("> deleteService() <");
		//log.printLogging("= deleteService() =");
		dao.deleteBoard(seq);
		
	}
	
}
