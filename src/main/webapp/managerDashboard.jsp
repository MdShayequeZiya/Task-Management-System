<%@page import="java.util.Comparator"%>
<%@page import="com.tms.entity.Task"%>
<%@page import="com.tms.entity.UserInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manager Dashboard</title>
<!-- Add any necessary CSS or scripts here -->
</head>
<body>

	<h2>Welcome, Manager!</h2>

	<!-- Manager-specific content and actions -->
	<form action="createTask" method="post">
		<!-- Add necessary form fields for creating a task -->
		<label for="taskDescription">Task Description:</label> <input
			type="text" id="taskDescription" name="taskDescription" required>
		<br> <label for="employeeId">Assign to Employee:</label> <select
			id="employeeId" name="employeeId" required>
			<%
            
            List<UserInfo> list = (List<UserInfo>) request.getAttribute("employeeList");
            
            for(UserInfo employee: list){
            
            %>

			<option value="<%= employee.getId() %>"><%= employee.getName() %>

				<%
            }
            
            %>
			
		</select> <br> <input type="submit" value="Create Task">
	</form>

	<!-- Display a list of tasks and their status -->
	<h3>Task List</h3>
	<table border="1">
		<tr>
			<th>Task ID</th>
			<th>Description</th>
			<th>Assigned To</th>
			<th>Status</th>
		</tr>
		<!-- Loop through tasks and display each row -->

		<%
            
            List<Task> taskList = (List<Task>) request.getAttribute("taskList");
			
			if (!taskList.isEmpty()) {
		        taskList.sort(new Comparator<Task>() {
		            @Override
		            public int compare(Task task1, Task task2) {
		                String status1 = task1.getStatus();
		                String status2 = task2.getStatus();
		                return status1.equalsIgnoreCase("open") && !status2.equalsIgnoreCase("open") ? -1 :
		                       !status1.equalsIgnoreCase("open") && status2.equalsIgnoreCase("open") ? 1 : 0;
		            }
		        });
			}
            
            for(Task task: taskList){
            
            %>
		<tr>
			<td><%= task.getId() %></td>
			<td><%= task.getDescription() %></td>
			<td><%= task.getAssignedTo().getName() %></td>
			<td><%= task.getStatus() %></td>
		</tr>
		<%} %>

	</table>

</body>
</html>
