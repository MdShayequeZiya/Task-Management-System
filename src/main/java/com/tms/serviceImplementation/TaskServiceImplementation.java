package com.tms.serviceImplementation;

import java.util.List;

import com.ff.service.TaskService;
import com.tms.dao.TaskDao;
import com.tms.entity.Task;

public class TaskServiceImplementation implements TaskService{

	@Override
	public void createTask(Task task, int employeeId) {
		
		TaskDao.saveTask(task, employeeId);
		
	}

	@Override
	public List<Task> getTaskByUserId(int userId) {
		
		return TaskDao.getTaskByEmployeeId(userId);
	}

	@Override
	public void updateTaskStatus(int taskId, String newStatus) {

		TaskDao.updateTaskStatus(taskId, newStatus);
		
	}

	@Override
	public List<Task> getAllTasks() {
		
		return TaskDao.getTaskList();
	}

}
