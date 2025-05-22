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
	out.println("model : test1 Parameter");
%>
	<p>
	Hello, ${name}. Nice to meet you
	</p>
	<p>your id is ${id }</p>
	
</body>
</html>