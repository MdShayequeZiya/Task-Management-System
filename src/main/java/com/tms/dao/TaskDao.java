package com.tms.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.tms.entity.Task;
import com.tms.entity.UserInfo;
import com.tms.helper.Connections;

public class TaskDao {

	
	public static Task saveTask(Task task, int employeeId) {
		
		EntityManager manager = Connections.manager;
		EntityTransaction transaction = Connections.transaction;
		
		UserInfo employee = UserDao.findUser(employeeId);
		
		task.setAssignedTo(employee);
		
		transaction.begin();
		
		manager.persist(task);
		
		transaction.commit();
		
		return task;
		
	}
	
	public static void updateTaskStatus(int taskId, String newStatus) {
		
		EntityManager manager = Connections.manager;
		EntityTransaction transaction = Connections.transaction;
		
		Task toUpdateTask = manager.find(Task.class, taskId);
		
		toUpdateTask.setStatus(newStatus);
		
		transaction.begin();
		
		manager.merge(toUpdateTask);
		
		transaction.commit();
		
	}
	
	public static List<Task> getTaskList(){
		
		EntityManager manager = Connections.manager;
		
		String queryString = "SELECT t from Task t";
		
		Query query = manager.createQuery(queryString);
		
		List<Task> resultList = query.getResultList();
		
		if(!resultList.isEmpty()) {
			return resultList;
		}
		
		List<Task> empty= new ArrayList<>();
		return empty;
	}
	
	public static List<Task> getTaskByEmployeeId(int id){
		EntityManager manager = Connections.manager;
		
		UserInfo employee = UserDao.findUser(id);
		
		String queryString = "SELECT t from Task t where t.assignedTo= ?1";
		
		Query query = manager.createQuery(queryString);
		
		query.setParameter(1, employee);
		
		List<Task> resultList = query.getResultList();
		if(!resultList.isEmpty()) {
			return resultList;
		}
		
		List<Task> empty= new ArrayList<>();
		return empty;
		
	}
}
