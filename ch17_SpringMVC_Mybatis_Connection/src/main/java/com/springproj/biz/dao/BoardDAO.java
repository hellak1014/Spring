package com.springproj.biz.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springproj.biz.domain.BoardVO;

@Repository("boardDAO")
public class BoardDAO extends SqlSessionDaoSupport{ // DAO(Data Access Object)
	
	@Autowired //자료형 주입받을래. 매서드에도 사용 가능하다.
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory); //상속에서만 쓸수 있는 super. 부모의 매서드 호출 가능.
		//자식이 객체로 받아온 것을 부모에게 다시 전달. 
	}
	
	//Mybatis로 sql 구문 이동.
	
	
	// CRUD 기능의 method 구현
	// 글 등록(insert문)
	public void insertBoard(BoardVO vo) {
	/*
	 * Object[] args = {vo.getTitle(), vo.getWriter(), vo.getContent()};
	 * jdbcTemplate.update(BOARD_INSERT, args); 
	 * 
	 */
		getSqlSession().insert("Board.insertBoard", vo); 
		//mybatis의 mapper와 연동하는 의미의 insert. 데이터 넣는거 아님. boardMapping에서 설정한 주소값으로 vo를 들고 찾아 가는 것.
		//그렇게 해서 mybatis가 객체를 반환해줌
	}
	
	// 목록보기(select문)
	public BoardVO getBoard(int seq) { //상세 설명창
		/*
		 * Object[] args = {seq}; return jdbcTemplate.queryForObject(BOARD_SELECT, args,
		 * new BoardRowMapper());
		 */
		
		 return getSqlSession().selectOne("Board.getBoard", seq); //  반환하는게 한개일때 selectOne 

	}
	
	public List<BoardVO> getBoardList(BoardVO vo) {
		
		/*
		 * //return jdbcTemplate.query(BOARD_LIST, new BoardRowMapper()); Object[] args
		 * = { vo.getSearchKeyword()};
		 */
		
		 if(vo.getSearchCondition().equals("TITLE")) {
	        return getSqlSession().selectList("Board.getBoardList_T", vo);  
	      }else if(vo.getSearchCondition().equals("CONTENT")) {
	    	  return getSqlSession().selectList("Board.getBoardList_C", vo);
	      } else {
	    	  return  getSqlSession().selectList("Board.getBoardList_T", vo);  
	      }

	}
	
	
	// 글 수정(update문)
	public void updateBoard(BoardVO vo) {
		/*
		 * Object[] args = {vo.getTitle(), vo.getContent(), vo.getSeq()};
		 * jdbcTemplate.update(BOARD_UPDATE, args);
		 */
		
		getSqlSession().update("Board.updateBoard", vo);
		
	}
	// 글 삭제(delete문)
	public void deleteBoard(int seq) {
		
		/* jdbcTemplate.update(BOARD_DELETE, seq); */
		
		getSqlSession().delete("Board.deleteBoard", seq);
		
	}
	
	
}

