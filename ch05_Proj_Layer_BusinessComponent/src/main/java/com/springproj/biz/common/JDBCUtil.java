package com.springproj.biz.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCUtil {
	
	
	//필드 매서드 참조변수 구성 가능
	
	
	public static Connection getConnection() {
		
		Connection conn = null; //필드에서 작성할때는 null값이 없어도 됨. 이 안에서 작성할때는 값이 필요하다. 
		//PreparedStatement pstmt = null; //연결이 이루어지고 나서 사용해야하기 때문에 필요 없음. 
		
		//1. 연결 
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //java한테 이곳에 있는 DB를 사용할거라고 알려줌.
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger"); 
			//자바에게 오라클 주소와 아이디 비번 알려줌. 자바가 DB에 접속. 매서드를 통해 내부에서 들어가고 주소값 conn 반환 (new와 같은 개념)
			//conn 이라는 객체가 생김. DB와 소통할 수 있는 참조변수 
			return conn;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return null;
		
	}
	
	public static void close(PreparedStatement pstmt, Connection conn) { //매개변수
		
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
