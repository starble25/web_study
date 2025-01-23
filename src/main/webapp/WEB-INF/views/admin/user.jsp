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
	<h1>user page</h1>
	<h2>사용자 상세페이지</h2>
	
	<p>아이디 : ${user.id}</p>
	<p>이름 : ${user.name}</p>
	
	<p>계정구분 :
		<c:choose>
			<c:when test="${user.userType == 'ADM'}">관리자</c:when>
			<c:when test="${user.userType == 'CUS'}">사용자</c:when>
		</c:choose>
	</p>
	
<%-- 	<button type="button" onClick="location.href='/admin/modifyUser' + '?id=${user.id}'">수정하기</button> --%>
	<button type="button" onClick="location.href='/admin/modifyUser/${user.id}'">수정하기</button>
	<button type="button" onClick="location.href='/admin/users'">사용자 목록보기</button>

</body>
</html>