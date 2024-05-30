<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!	int calc(int a, int b){
	return a+b;
} %>
<%
	String[] name = {"홍길동", "김선우", "양태식"};
%>
<h1>지시어 테스트</h1>
<h3>calc(20,20) : <%=calc(20,20)%> </h3>
<!-- html 주석 -->
<%--jsp 주석 --%>
<h2>이름 리스트</h2>
<h3>members: <%for(String members : name){ %> <li> <%=members%><%} %></li></h3>
</body>
</html>