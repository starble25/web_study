<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>count page</h1>
	
	<c:if test="${loginId == null}">
		<p> 접속한 사용자가 없습니다 </p>
		<!-- <p> 접속 횟수 : 0 </p>  -->
	</c:if>
	
	<c:if test="${loginId != null}">
		<p> ${loginId} 님이 접속하셨습니다 </p>
		<!-- <p> 접속 횟수 : ${count} </p>  -->
	</c:if>
	
	<p> 접속 횟수 : ${count} </p>
	
</body>
</html>