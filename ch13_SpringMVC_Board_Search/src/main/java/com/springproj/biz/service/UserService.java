package com.springproj.biz.service;

import com.springproj.biz.domain.UserVO;

public interface UserService {
	//CRUD 기능의 매서드 구현
	
	//회원 등록 (c)
	
	//회원 상세정보 R
	public UserVO getService(UserVO user);
	
}
