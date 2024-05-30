<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카운터</title>
</head>
<body>
<%! int count = 0; %>
<% count+=1; %>
<p>
	<%=count %>
</p>
<img alt="<%=count %>.jpg" src="../img/<%=count%>.jpg" width=100>

</body>
</html>