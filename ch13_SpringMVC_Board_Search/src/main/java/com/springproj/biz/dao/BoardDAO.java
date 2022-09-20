package com.springproj.biz.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springproj.biz.domain.BoardVO;

@Repository("boardDAO")
public class BoardDAO { // DAO(Data Access Object)
	
	//*
	private final String BOARD_INSERT 
		= "insert into board(seq,title,writer,content) values("
				+ "(select nvl(max(seq),0)+1 from board), ?, ?, ?)";
	//*/
	
	/*
	 * private final String BOARD_INSERT 
	= "insert into board(seq,title,writer,content) values("
			+ "?, ?, ?, ?)";
	//*/
	
	private final String BOARD_UPDATE
		= "update board set title = ?, content = ? where seq = ?";
	
	private final String BOARD_SELECT
		= "select * from board where seq = ?";
	
	/*
	 * private final String BOARD_LIST = "select * from board order by seq desc";
	 */
	
	//검색 기능 추가
	private final String BOARD_LIST_T //제목 기준 검색
	= "select * from board where title like '%'||?||'%' order by seq desc";  //사용자가 입력한 문자 ? 앞뒤로 어떤게 와도 상관없다. % ||
	
	private final String BOARD_LIST_C //내용 기준 검색
	= "select * from board where content like '%'||?||'%' order by seq desc";
	
	
	private final String BOARD_DELETE
	= "delete from board where seq = ?";

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	
	
	// CRUD 기능의 method 구현
	// 글 등록(insert문)
	public void insertBoard(BoardVO vo) {
		
		/*
		 * jdbcTemplate.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(),
		 * vo.getContent());
		 */
		
		Object[] args = {vo.getTitle(), vo.getWriter(), vo.getContent()};
		//Object[] args = {vo.getSeq(), vo.getTitle(), vo.getWriter(), vo.getContent()};
		jdbcTemplate.update(BOARD_INSERT, args);
		
	}
	
	// 목록보기(select문)
	public BoardVO getBoard(int seq) {
		
		//이벤트 방식으로 데이터를 전달 받는다. => 인터페이스 방식. 매서드를 호출해서 데이터를 입력하는 방식.
		
		Object[] args = {seq};
		
		return jdbcTemplate.queryForObject(BOARD_SELECT, args, new BoardRowMapper()); 
		//하나의 결과값을 받을때 사용하는 것. 내가 정의해둔 인스턴스에 넣어주라. 
		
		
	}
	
	public List<BoardVO> getBoardList(BoardVO vo) {
		
		//return jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());
		Object[] args = {vo.getSearchKeyword()}; //물음표에 들어갈 값. 사용자가 검색조건으로 입력한 텍스트.
		
		
		if (vo.getSearchCondition().equals("TITLE")){
			return jdbcTemplate.query(BOARD_LIST_T, args, new BoardRowMapper());
		} else if(vo.getSearchCondition().equals("CONTENT")) {
			return jdbcTemplate.query(BOARD_LIST_C, args, new BoardRowMapper());
		}
		
		return null; //입력하지 않고 리스트를 출력했을때 오류를 방지하는 리턴 null. 
		
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
	
	class BoardRowMapper implements RowMapper<BoardVO>{

		//select문을 sql에 넣고, sql이 데이터를 보내줬을때 작동이 된다.
		
		@Override
		public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			BoardVO board = new BoardVO();
			
			board.setSeq(rs.getInt("seq"));
			board.setTitle(rs.getString("title"));
			board.setWriter(rs.getString("writer"));
			board.setContent(rs.getString("content"));
			board.setRegdate(rs.getDate("regdate"));
			board.setCnt(rs.getInt("cnt"));
			

			return board;
		}
	}
	
	
}
