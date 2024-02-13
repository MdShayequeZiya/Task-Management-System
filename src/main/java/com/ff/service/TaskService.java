package com.ff.service;

import java.util.List;

import com.tms.entity.Task;

public interface TaskService {
	
	void createTask(Task task, int employeeId); 
	
	List<Task> getTaskByUserId(int userId);
	
	void updateTaskStatus(int taskId, String newStatus);
	
	List<Task> getAllTasks();
	

}
