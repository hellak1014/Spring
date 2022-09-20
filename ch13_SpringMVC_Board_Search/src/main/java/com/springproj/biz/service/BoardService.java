package com.springproj.biz.service;

import java.util.List;

import com.springproj.biz.domain.BoardVO;

public interface BoardService {
	// CRUD 기능 수행을 위한 메서드 호출 기능.
	// 글 등록
	void insertService(BoardVO vo);
	// 글 목록 조회
	BoardVO getService(int seq);
	List<BoardVO> getServiceList(BoardVO vo); //검색기능 추가로 인한 매개변수 추가. (검색 조건을 받아와야함) Impl도 변경해야함. 
	// 글 수정
	void updateService(BoardVO vo);
	// 글 삭제
	void deleteService(int seq);
}