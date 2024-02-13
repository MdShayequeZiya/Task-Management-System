package com.tms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ff.service.TaskService;
import com.ff.service.UserService;
import com.tms.entity.Task;
import com.tms.entity.UserInfo;
import com.tms.serviceImplementation.TaskServiceImplementation;
import com.tms.serviceImplementation.UserServiceImplemenation;

@WebServlet("/manager")
public class ManagerController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		UserService userService = new UserServiceImplemenation();

		TaskService taskService = new TaskServiceImplementation();

		List<UserInfo> employeeList = userService.getAllEmployees();

		List<Task> tasks = taskService.getAllTasks();

		req.setAttribute("employeeList", employeeList);
		req.setAttribute("taskList", tasks);

		RequestDispatcher dispatcher = req.getRequestDispatcher("managerDashboard.jsp");
		dispatcher.forward(req, resp);

	}

}
