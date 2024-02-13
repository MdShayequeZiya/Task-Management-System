<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<form action="login" method="post">
        <!-- Add necessary form fields -->
        <label for="email">EMAIL:</label>
        <input type="text" id="username" name="email" required>
        <br>
        
        <label for="password">PASSWORD:</label>
        <input type="password" id="password" name="password" required>
        <br>

        <input type="submit" value="Login">
    </form>

</body>
</html>