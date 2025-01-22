package com.app.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.common.CommonCode;
import com.app.dao.user.UserDAO;
import com.app.dto.user.User;
import com.app.service.user.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDAO userDAO;

	@Override
	public int saveUser(User user) {
		
		int result = userDAO.saveUser(user);
		
		return result;
	}

	@Override
	public int saveCustomerUser(User user) {
		//사용자 추가 전 검증 로직
		user.setUserType(CommonCode.USER_USERTYPE_CUSTOMER);
		int result = userDAO.saveUser(user);
		return result;
	}

	@Override
	public int saveAdminUser(User user) {
		//사용자 추가 전 검증 로직
		user.setUserType(CommonCode.USER_USERTYPE_ADMIN);
		int result = userDAO.saveUser(user);
		return result;
	}

	@Override
	public List<User> findUserList() {
		List<User> userList = userDAO.findUserList();
		return userList;
	}

	@Override
	public User checkUserLogin(User user) {
		//1. 서비스 자체에서 로직을 수행
		User loginUser = userDAO.findUserById(user.getId());
		if( loginUser != null && user.getPw().equals(loginUser.getPw())
				&& loginUser.getUserType().equals(user.getUserType()) ) { // 비밀번호 맞다
			return loginUser;
		}
		
		return null;
		
		// 아이디&비번이 맞으면 loginUser
		// 아이디x? 아이디o & 비번x null
		
		//2. DAO -> Mapper 쿼리를 만들어서 비교하는 방법
		
	}

	@Override
	public User findUserById(String id) {
		User user = userDAO.findUserById(id);
		return user;
	}
}
