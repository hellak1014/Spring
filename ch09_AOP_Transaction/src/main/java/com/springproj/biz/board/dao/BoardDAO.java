package com.springproj.biz.board.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springproj.biz.board.BoardVO;

@Repository("boardDAO")
public class BoardDAO { // DAO(Data Access Object)
	
	/*
	private final String BOARD_INSERT 
		= "insert into board(seq,title,writer,content) values("
				+ "(select nvl(max(seq),0)+1 from board), ?, ?, ?)";
	//*/
	
	private final String BOARD_INSERT 
	= "insert into board(seq,title,writer,content) values("
			+ "?, ?, ?, ?)";
	
	private final String BOARD_UPDATE
		= "update board set title = ?, content = ? where seq = ?";
	
	private final String BOARD_SELECT
		= "select * from board where seq = ?";
	
	private final String BOARD_LIST
	= "select * from board order by seq";
	
	private final String BOARD_DELETE
	= "delete from board where seq = ?";

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//@Autowired
	//private LogAdvice log;
	
	
	// CRUD 기능의 method 구현
	// 글 등록(insert문)
	public void insertBoard(BoardVO vo) {
		
		/*
		 * jdbcTemplate.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(),
		 * vo.getContent());
		 */
		
		/* Object[] args = {vo.getTitle(), vo.getWriter(), vo.getContent()}; */
		Object[] args = {vo.getSeq(), vo.getTitle(), vo.getWriter(), vo.getContent()};
		jdbcTemplate.update(BOARD_INSERT, args);
		
	}
	
	// 목록보기(select문)
	public BoardVO getBoard(int seq) {
		
		//이벤트 방식으로 데이터를 전달 받는다. => 인터페이스 방식. 매서드를 호출해서 데이터를 입력하는 방식.
		
		Object[] args = {seq};
		
		return jdbcTemplate.queryForObject(BOARD_SELECT, args, new BoardRowMapper()); 
		//하나의 결과값을 받을때 사용하는 것. 내가 정의해둔 인스턴스에 넣어주라. 
		
		
	}
	
	public List<BoardVO> getBoardList() {
		
		return jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());
		//시작 주소값만 알려주고 계속 출력하게끔 한다. 
		
		
	}
	
	
	// 글 수정(update문)
	public void updateBoard(BoardVO vo) {
		
		Object[] args = {vo.getTitle(), vo.getContent(), vo.getSeq()};
		jdbcTemplate.update(BOARD_UPDATE, args);
		/*
		 * jdbcTemplate.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(),
		 * vo.getSeq());
		 */
		
	}
	// 글 삭제(delete문)
	public void deleteBoard(int seq) {
	
		jdbcTemplate.update(BOARD_DELETE, seq);
		
	}
}
