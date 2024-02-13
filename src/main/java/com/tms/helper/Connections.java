package com.tms.helper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Connections {
	
	
	public static EntityManagerFactory factory;
	public static EntityManager manager;
	public static EntityTransaction transaction;
	
	static {
		
		factory = Persistence.createEntityManagerFactory("user");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
		
	}

}
