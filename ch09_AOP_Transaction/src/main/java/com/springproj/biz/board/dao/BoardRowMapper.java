package com.springproj.biz.board.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springproj.biz.board.BoardVO;

public class BoardRowMapper implements RowMapper<BoardVO>{

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
