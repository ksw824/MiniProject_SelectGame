<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계산결과-jsp</title>
</head>
<body>
	<%int a = Integer.parseInt(request.getParameter("n1"));
	int b = Integer.parseInt(request.getParameter("n2"));
	double result=0;
	switch(request.getParameter("op")){
	case "+" : result = a+b;break;
	case "-" : result = a-b;break;
	case "/" : result = a/b;break;
	case "*" : result = a*b;break;
	}%>  
	<p>결과:<%=result%></p>
</body>
</html>