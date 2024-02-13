<%@page import="com.tms.entity.Task"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Welcome, Employee!</h2>

	<!-- Display a list of tasks assigned to the employee -->
	<h3>Task List</h3>
	<table border="1">
		<tr>
			<th>Task ID</th>
			<th>Description</th>
			<th>Status</th>
			<th>Action</th>
		</tr>
		<%
		List<Task> taskList = (List<Task>) request.getAttribute("taskList");

		if (taskList != null && !taskList.isEmpty()) {
			for (Task task : taskList) {
		%>
		<tr>
			<td><%=task.getId()%></td>
			<td><%=task.getDescription()%></td>
			<td><%=task.getStatus()%></td>
			<td>
				<form action="employee" method="post">
                            <input type="hidden" name="taskId" value="<%= task.getId() %>">
                            <input type="submit" value="Complete">
                        </form>
			</td>
		</tr>
		<%
		}
		} else {
		%>
		<tr>
			<td colspan="4">No tasks assigned</td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>