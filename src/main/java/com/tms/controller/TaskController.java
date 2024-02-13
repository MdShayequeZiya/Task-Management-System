package com.tms.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ff.service.TaskService;
import com.ff.service.UserService;
import com.tms.entity.Task;
import com.tms.serviceImplementation.TaskServiceImplementation;
import com.tms.serviceImplementation.UserServiceImplemenation;

@WebServlet("/createTask")
public class TaskController extends HttpServlet {
	
	private final TaskService taskService = new TaskServiceImplementation();
	private final UserService userService = new UserServiceImplemenation();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String taskDescription = req.getParameter("taskDescription");
		int employeeId = Integer.parseInt(req.getParameter("employeeId"));
		
		Task task = new Task();
		task.setDescription(taskDescription);
		task.setStatus("OPEN");
		
		taskService.createTask(task, employeeId);
		
		resp.sendRedirect("manager");
		
		
	}

}
