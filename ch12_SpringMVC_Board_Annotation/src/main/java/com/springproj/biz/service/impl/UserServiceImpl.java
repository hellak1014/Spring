package com.springproj.biz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.springproj.biz.dao.UserDAO;
import com.springproj.biz.domain.UserVO;
import com.springproj.biz.service.UserService;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO dao;
	
	@Override
	public UserVO getService(UserVO user) {
		
		dao.getUser(UserVO user);
		
		return null;
	}

}
