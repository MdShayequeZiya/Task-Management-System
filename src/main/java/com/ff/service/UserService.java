package com.ff.service;

import java.util.List;

import com.tms.entity.UserInfo;

public interface UserService {
	
	void registerUser(UserInfo user);
	
	UserInfo loginUser(String email, String password);
	
	List<UserInfo> getAllEmployees();

}
