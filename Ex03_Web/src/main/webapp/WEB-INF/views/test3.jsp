<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jspView</title>
</head>
<body>
<%
	out.println("model : test3 Path variable");
%>
	<p>
	Hello, ${studentID}. Nice to meet you
	</p>
	<p>your name is ${name }</p>
	
</body>
</html>