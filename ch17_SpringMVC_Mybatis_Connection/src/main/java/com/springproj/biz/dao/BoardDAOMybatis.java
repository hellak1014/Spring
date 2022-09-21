package com.springproj.biz.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springproj.biz.domain.BoardVO;

@Repository //객체 생성해줘
public class BoardDAOMybatis {
	
	@Autowired
	SqlSessionTemplate mybatis; //root-context.xml에서 만들어둔 template를 선언하기.
	

	//CRUD기능 구현
	
	public void insertBoard(BoardVO vo) {
		
		mybatis.insert("Board.insertBoard", vo); 
			//mybatis의 mapper와 연동하는 의미의 insert. 데이터 넣는거 아님. boardMapping에서 설정한 주소값으로 vo를 들고 찾아 가는 것.
			//그렇게 해서 mybatis가 객체를 반환해줌
		}
		
		// 목록보기(select문)
		public BoardVO getBoard(int seq) { //상세 설명창
			
			
			 return mybatis.selectOne("Board.getBoard", seq); //  반환하는게 한개일때 selectOne 

		}
		
		public List<BoardVO> getBoardList(BoardVO vo) {
			
//			2번 방법			
//			 if(vo.getSearchCondition().equals("TITLE")) {
//		        return mybatis.selectList("Board.getBoardList_T", vo);  
//		      }else if(vo.getSearchCondition().equals("CONTENT")) {
//		    	  return mybatis.selectList("Board.getBoardList_C", vo);
//		      } else {
//		    	  return mybatis.selectList("Board.getBoardList_T", vo);  
//		      }
			
//			동적 sql문. 
			
			return mybatis.selectList("Board.getBoardList", vo);

		}
		
		
		// 글 수정(update문)
		public void updateBoard(BoardVO vo) {
			
			
			mybatis.update("Board.updateBoard", vo);
			
		}
		// 글 삭제(delete문)
		public void deleteBoard(int seq) {
			
			
			mybatis.delete("Board.deleteBoard", seq);
			
		}
	
	
}
