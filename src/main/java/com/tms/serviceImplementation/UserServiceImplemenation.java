package com.tms.serviceImplementation;

import java.util.List;

import com.ff.service.UserService;
import com.tms.dao.UserDao;
import com.tms.entity.UserInfo;

public class UserServiceImplemenation implements UserService {

	@Override
	public void registerUser(UserInfo user) {
		 UserDao.saveUser(user);
		
	}

	@Override
	public UserInfo loginUser(String email, String password) {
		
		UserInfo loginUser = UserDao.loginUser(email, password);
		return loginUser;
	}

	@Override
	public List<UserInfo> getAllEmployees() {
		
		return UserDao.getAllUserByRole("EMPLOYEE");
		
	}

}
