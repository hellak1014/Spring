package com.springproj.biz.service;

import com.springproj.biz.domain.UserVO;

public interface UserService {

	//회원 상세정보 R
	UserVO getService(String id, String password);
	
}
