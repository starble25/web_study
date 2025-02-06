<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>관리자 페이지</h1>
	<h2>사용자 추가</h2>
	
	<form action="" method="post" id="frm_user">
		<label>ID : <input type="text" name="id" required="required" id="input_id"></label><br>
		<label>이름 : <input type="text" name="name"></label><br>
		
		<br>
		<button type="submit">등록하기</button>
	</form>
	
	<script>
// 		let frm_user = document.getElementById('frm_user');
// 		frm_user.addEventListener('submit', (event)=>{
// 			event.preventDefault();
// 			let input_id = document.getElementById('input_id').value;
// 			if(input_id.length < 2) {
// 				alert('아이디 2글자 이상');
// 				return;
// 			}
			
// 			//모두 통과 -> submit 진행
// 			frm_user.submit();
// 		});
	</script>
</body>
</html>