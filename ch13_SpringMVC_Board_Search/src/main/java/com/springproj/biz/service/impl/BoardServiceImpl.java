package com.springproj.biz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproj.biz.dao.BoardDAO;
import com.springproj.biz.domain.BoardVO;
import com.springproj.biz.service.BoardService;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO dao;
	//@Autowired
	//private LogAdvice log;
	//private Log4jAdvice log;
	
	@Override
	public void insertService(BoardVO vo) {
		//log.printLog("= insertService() =");
		//log.printLogging("= insertService() =");
		
		//if(vo.getSeq() == 0) {
		//	throw new IllegalArgumentException("0번 글은 등록할 수 없습니다.");
		//}
		dao.insertBoard(vo);
		//dao.insertBoard(vo);
	}

	@Override
	public BoardVO getService(int seq) {
		//log.printLog("= getService() =");
		BoardVO board = dao.getBoard(seq);
		
		return board;
	}

	@Override
	public List<BoardVO> getServiceList(BoardVO vo) { //검색기능 추가로 인한 매개변수 추가. (검색 조건을 받아와야함) service도 변경해야함.
		//log.printLog("= getServiceList() =");
		return dao.getBoardList(vo);
	}

	@Override
	public void updateService(BoardVO vo) {
		//log.printLog("= updateService() =");
		dao.updateBoard(vo);
	}

	@Override
	public void deleteService(int seq) {
		dao.deleteBoard(seq);
	}

}
