package com.tms.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ff.service.UserService;
import com.tms.entity.UserInfo;
import com.tms.serviceImplementation.UserServiceImplemenation;


@WebServlet(value = "/register-user")
public class UserRegisterServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String userName = req.getParameter("user_name");
		String email = req.getParameter("user_email");
		String designation = req.getParameter("user_designation");
		String role = req.getParameter("user_role").toUpperCase();
		double salary = Double.parseDouble(req.getParameter("user_salary"));
		String password = req.getParameter("user_password");
		
		UserInfo user = new UserInfo();
		user.setName(userName);
		user.setEmail(email);
		user.setDesignation(designation);
		user.setPassword(password);
		user.setSalary(salary);
		user.setRole(role);
		
		UserService userService = new UserServiceImplemenation();
		userService.registerUser(user);
		
		resp.sendRedirect("login.jsp");
		
		
	}

}
