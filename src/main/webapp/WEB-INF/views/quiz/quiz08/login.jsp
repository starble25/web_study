<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>login page</h1>

	<!-- <form action="" method="post">  -->
	<form action="/quiz/session/login" method="post">
		ID: <input type="text" name="id"><br>
		PW: <input type="password" name="pw"><br>
		<button type="submit">로그인</button>
	</form>

</body>
</html>