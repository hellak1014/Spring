package com.springproj.biz.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproj.biz.dao.BoardDAOMybatis;
import com.springproj.biz.domain.BoardVO;
import com.springproj.biz.service.BoardService;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	//private BoardDAO dao;   //1번 방법
	private BoardDAOMybatis dao;  //2번 방법
	
	@Override
	public void insertService(BoardVO vo) {
		//log.printLog("= insertService() =");
		//log.printLogging("= insertService() =");
		
		/*
		if(vo.getSeq() == 0) {
			throw new IllegalArgumentException("0번 글은 등록할 수 없습니다.");
		}
		//*/
		
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
	public List<BoardVO> getServiceList(BoardVO vo) {
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