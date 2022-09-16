package com.springproj.biz.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springproj.biz.domain.UserVO;

@Repository("userDAO") //객체 생성해주라
public class UserDAO {
	@Autowired
	JdbcTemplate jdbcTemplate; //jdbcTemplate사용을 위한 bean 주입 요청.
	
	private final String USER_GET = "select * form users where id=? and password=? ";
	
	//CRUD 기능의 메소드 구현
	//회원 상세 정보 R
	
	public UserVO getUser(UserVO user) { //입력으로 온 데이터를 전달받아야함
		//System.out.println("getUser 메서드 호출");
		
		Object[] args = {user.getId(), user.getPassword()}; //가져온 데이터를 object의 배열로 만들고, 이름을 args로 한다.
		
		return jdbcTemplate.queryForObject(USER_GET, args, new UserRowMapper());
	}
	
}
