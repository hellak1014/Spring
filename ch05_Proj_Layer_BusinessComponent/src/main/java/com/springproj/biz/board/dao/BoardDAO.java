package com.springproj.biz.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.springproj.biz.board.BoardVO;
import com.springproj.biz.common.JDBCUtil;

public class BoardDAO { //DAO (Data Access Object) 
	private final String BOARD_INSERT = "insert into board(seq,title,writer,content) values("
									+ "(select nvl(max(seq),0)+1 from board), ?, ?, ?)"; //seq의 번호가 하나씩 증가하게 함. 
	private final String BOARD_UPDATE = "update board set title = ?, content = ? where seq = ?";
	/* private final String BOARD_DELETE = "delete board " */
	
	Connection conn;
	
	
	

	// CRUD 기능의 매서드 구현. 
	// 글 등록 (insert문) [Create]
	public void insertBoard(BoardVO vo) {
		
		/* 연결은 반복적인 코드이기 때문에 따로 util 파일로 뺌. */
		
			conn = JDBCUtil.getConnection();
		
		//2. JDBC를 이용해 sql 처리
			
			PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(BOARD_INSERT); //conn이라는 주소에 prepareStatement하고 나온 값을 pstmt로 받음 (참조변수2)
			pstmt.setString(1, vo.getTitle()); //vo에 있는 title을 getter로 꺼내 1번 물음표에 넣어라. 
			pstmt.setString(2, vo.getWriter()); //vo에 있는 content를 getter로 꺼내 2번 물음표에 넣어라.
			pstmt.setString(3, vo.getContent()); 		
			int result = pstmt.executeUpdate(); //jdbc한테 쿼리문 날리라고 하기.
			
			if (result == 1) {
				System.out.println("===> 데이터 저장 성공");
			}else {
				System.out.println("===> 데이터 저장 실패");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			JDBCUtil.close(pstmt, conn);

		}
		
	}
	
	
	
	
	
	// 목록보기 (select문) [Read]
	public void getBoard(int seq) {
		
		conn = JDBCUtil.getConnection();
		
	}
	
	public void getBoardList() {
		
		conn = JDBCUtil.getConnection();
		
	}
	
	
	
	
	// 글 수정 (update문) [Update]
	public void updateBoard(BoardVO vo) {
		
		conn = JDBCUtil.getConnection();
		 
		
		//2. JDBC를 이용해 sql 처리
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(BOARD_UPDATE); //conn이라는 주소에 prepareStatement하고 나온 값을 pstmt로 받음 (참조변수2)
			pstmt.setString(1, vo.getTitle()); //vo에 있는 title을 getter로 꺼내 1번 물음표에 넣어라. 
			pstmt.setString(2, vo.getWriter()); //vo에 있는 content를 getter로 꺼내 2번 물음표에 넣어라.
			pstmt.setInt(3, vo.getSeq()); // vo에 있는 마지막 seq를 getter로 꺼내 3번 물음표에 넣어라. 기본형이 int니까 int
			int result = pstmt.executeUpdate(); //jdbc한테 쿼리문 날리라고 하기.
			
			if (result == 1) {
				System.out.println("===> 데이터 수정 성공");
			}else {
				System.out.println("===> 데이터 수정 실패");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			JDBCUtil.close(pstmt, conn);
		}
		
	}
	
	
	
	
	// 글 삭제 (delete문) [Delete]
	public void deleteBoard(int seq) {
		
	}
	
}
