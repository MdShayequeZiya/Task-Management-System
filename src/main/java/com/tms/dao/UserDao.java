package com.tms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.tms.entity.UserInfo;
import com.tms.helper.Connections;

public class UserDao {
	
	
	public static UserInfo saveUser(UserInfo user) {
		
		EntityManager manager = Connections.manager;
		EntityTransaction transaction = Connections.transaction;
		
		transaction.begin();
		
		manager.persist(user);
		
		transaction.commit();
		
		return user;
		
		
	}
	
	
	public static UserInfo loginUser(String email, String password) {
		EntityManager manager = Connections.manager;
		
		String queryString = "SELECT u from UserInfo u where u.email = ?1 and u.password = ?2";
		
		Query query = manager.createQuery(queryString);
		query.setParameter(1, email);
		query.setParameter(2, password);
		
		List<UserInfo> resultList = query.getResultList();
		
		if(!resultList.isEmpty()) {
			return resultList.get(0);
		}
		
		return null;
		
	}
	
	public static UserInfo findUser(int userId) {
		return Connections.manager.find(UserInfo.class, userId);
	}


	public static List<UserInfo> getAllUserByRole(String role) {
		
		EntityManager manager = Connections.manager;
		
		String queryString = "SELECT u from UserInfo u where u.role = :role";
		
		Query query = manager.createQuery(queryString);
		
		query.setParameter("role", role);
		
		List<UserInfo> resultList = query.getResultList();
		if(!resultList.isEmpty())
			return resultList;
		
		return null;
	}

}
