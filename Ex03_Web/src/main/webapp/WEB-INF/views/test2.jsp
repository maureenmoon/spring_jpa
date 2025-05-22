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
	out.println("model : test2 DTO");
%>
	<p>
	Hello, ${member.name}. Nice to meet you
	</p>
	<p>your id is ${member.id }</p>
	
</body>
</html>