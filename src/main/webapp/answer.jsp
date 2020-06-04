<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="assignment2.*"%>
<%
    Wolf wolf = (Wolf) request.getAttribute("wolf");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>assignment2</title>
	</head>
	<body>
		<%= wolf.getAnswer() %>
	</body>
</html>