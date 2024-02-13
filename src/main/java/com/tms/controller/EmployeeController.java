package com.tms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ff.service.TaskService;
import com.tms.entity.Task;
import com.tms.serviceImplementation.TaskServiceImplementation;


@WebServlet("/employee")
public class EmployeeController extends HttpServlet{
	
	
	private final TaskService taskService = new TaskServiceImplementation();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		int employeeId =(int) session.getAttribute("userId");
		System.out.println(employeeId);
		List<Task> taskList = taskService.getTaskByUserId(employeeId);
		
		System.out.println(taskList.size());
		req.setAttribute("taskList", taskList);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("employeeDashboard.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int taskId = Integer.parseInt(req.getParameter("taskId"));
		
		taskService.updateTaskStatus(taskId, "COMPLETED");
		
		System.out.println("hii");
		
		resp.sendRedirect("employee");
		
		
	}

}
