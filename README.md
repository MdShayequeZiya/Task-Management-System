# Task Management System

A simple web-based task management system using Java Servlets, Hibernate, and MVC architecture.

## Project Overview

This project is a basic task management system with features for user registration, login, and role-based access control. It allows managers to create tasks, assign them to employees, and track their statuses. Employees can view and complete their assigned tasks.

## Technologies Used

- Java
- Servlets
- Hibernate (with persistence.xml)
- JSP (JavaServer Pages)
- HTML/CSS
- MySQL (or your preferred database)

## Project Structure

/task-management-system
│
├── src
│ ├── main
│ │ ├── java
│ │ │ ├── com.ff
│ │ │ │ ├── controller
│ │ │ │ │ ├── RegisterController.java
│ │ │ │ │ ├── LoginController.java
│ │ │ │ │ ├── ManagerController.java
│ │ │ │ │ ├── EmployeeController.java
│ │ │ │ ├── service
│ │ │ │ │ ├── UserService.java
│ │ │ │ │ ├── TaskService.java
│ │ │ │ │ ├── implementation
│ │ │ │ │ │ ├── UserServiceImpl.java
│ │ │ │ │ │ ├── TaskServiceImpl.java
│ │ │ │ ├── dao
│ │ │ │ │ ├── UserDao.java
│ │ │ │ │ ├── TaskDao.java
│ │ │ │ ├── entity
│ │ │ │ │ ├── User.java
│ │ │ │ │ ├── Task.java
│ │ │ ├── resources
│ │ │ │ ├── META-INF
│ │ │ │ │ ├── persistence.xml
│ │ ├── webapp
│ │ │ ├── WEB-INF
│ │ │ │ ├── views
│ │ │ │ │ ├── register.jsp
│ │ │ │ │ ├── login.jsp
│ │ │ │ │ ├── managerDashboard.jsp
│ │ │ │ │ ├── employeeDashboard.jsp
├── WebContent
│ ├── index.jsp
│ ├── web.xml
│ ├── README.md


## How to Use

1. Clone the repository:

```bash
git clone https://github.com/yourusername/task-management-system.git


## How to Use

1. Clone the repository:

```bash
git clone https://github.com/yourusername/task-management-system.git
