<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>객실 추가</h1>
	
	<form action="" method="post">
		<label>건물/동 번호<input type="text" name="buildingNumber"></label><br>
		<label>호실 번호<input type="text" name="roomNumber"></label><br>
		<label>층수<input type="text" name="floor"></label><br>
		<label>최대숙박인원<input type="text" name="maxGuestCount"></label><br>
		
		<p>뷰타입</p>
		<select name="viewType">
			<option value="OCN">오션뷰</option>
			<option value="CTY">시티뷰</option>
			<option value="MOT">마운틴뷰</option>
		</select>
		
		<br>
		<button type="submit">객실추가</button>
		
		<button type="button" onClick="location.href='/admin/rooms'">객실 목록보기</button>
	</form>
</body>
</html>