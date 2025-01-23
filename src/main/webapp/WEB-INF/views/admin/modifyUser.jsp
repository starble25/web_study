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
	<h1>사용자 수정 페이지</h1>
	
	<form action="/admin/modifyUser" method="post">
<%-- 	ID : <input type="text" name="id" value="${user.id}" readonly><br> --%>
		<input type="hidden" name="id" value="${user.id}"><br>
		ID : <input type="text" name="id" value="${user.id}" disabled><br>
		PW : <input type="password" name="pw" value="${user.pw}"><br>
		이름 : <input type="text" name="name" value="${user.name}"><br>
		
		사용자 타입 선택 : 
		<label>고객<input type="radio" name="userType" value="CUS" <c:if test="${user.userType == 'CUS'}">checked</c:if> ></label>
		<label>관리자<input type="radio" name="userType" value="ADM" <c:if test="${user.userType == 'ADM'}">checked</c:if> ></label>
		
<!-- 		<select name="userType"> -->
<%-- 			<option value="ADM" <c:if test="${user.userType == 'ADM'}">selected</c:if> >관리자</option> --%>
<%-- 			<option value="CUS" <c:if test="${user.userType == 'CUS'}">selected</c:if> >사용자</option> --%>
<!-- 		</select> -->
		
		<br>
		<button type="submit">수정하기</button>
	</form>
</body>
</html>