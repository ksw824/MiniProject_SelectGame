<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>정보 입력</h2>
	<hr>
	<form action="/jwbook/userControl?action=join" method="post">
		<label>아이디</label>
		<input type="text" name="id"><br>
		<label>비밀번호</label>
		<input type="text" name="password"><br>
		<label>이름</label>
		<input type="text" name="name"><br>
		
		<button type="submit">가입</button> 
	</form>
		
</body>
</html>