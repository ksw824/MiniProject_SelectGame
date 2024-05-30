<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello World</title>

<style>
	body {color: blue;}
	h1 {color: red;}
	h1 {background-color: green; }
</style>
</head>
<body>
	<h1>Hello World1</h1>
	<h2>Hello World2</h2>
	<hr>	
	<hr>
	현재 날짜와 시간은
	<%=java.time.LocalDateTime.now()%>입니다.
</body>
</html>