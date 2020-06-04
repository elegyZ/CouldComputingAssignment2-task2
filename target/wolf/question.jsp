<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Question</title>
	</head>
	<body>
	<h1>
	This is Question
	</h1>
		<form action="wolf" method="post">
		Ask A Question: <input type="text" name="question">
		<input type="submit" value="提交" />
		</form>
	</body>
</html>