package com.app.dao.user;

import java.util.List;

import com.app.dto.user.User;
import com.app.dto.user.UserSearchCondition;

public interface UserDAO {

	int saveUser(User user);
	
	List<User> findUserList();
	
	User findUserById(String id);
	
	public User checkUserLogin(User user);
	
	int modifyUser(User user);
	
	List<User> findUserListBySearchCondition(UserSearchCondition userSearchCondition);
}
