package com.tms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ff.service.UserService;
import com.tms.entity.UserInfo;
import com.tms.serviceImplementation.UserServiceImplemenation;


@WebServlet("/login")
public class LoginUser extends HttpServlet {
	
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("user");
	private EntityManager manager = factory.createEntityManager();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
        String password = req.getParameter("password");

        UserService userService = new UserServiceImplemenation();
        UserInfo user = userService.loginUser(email, password);
        

        if (user != null) {
            // Successful login, redirect to dashboard or another page
        	HttpSession session =  req.getSession();
        	session.setAttribute("userId", user.getId());
        	
        	if(user.getRole().equalsIgnoreCase("Manager")) {
        		 resp.sendRedirect("manager");
        	}
        	else {
        		 resp.sendRedirect("employee");
        	}
        } else {
            // Failed login, redirect back to login page with an error message
            req.setAttribute("errorMessage", "Invalid username or password");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
		
		
	}

}
