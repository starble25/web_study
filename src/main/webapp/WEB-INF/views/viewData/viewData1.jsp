<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>viewData1 page</h1>
	
	<%=request.getAttribute("state")%>
	<%=request.getAttribute("time")%>
	
	<p>${state}</p>
	<div>
		<p></p>
		<span>${time}</span>
	</div>
</body>
</html>