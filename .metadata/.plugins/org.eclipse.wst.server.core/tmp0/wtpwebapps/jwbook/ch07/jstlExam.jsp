<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 종합 예제</title>
</head>
<body>
	<h2>JSTL 종합 예</h2>
	<hr>
	<h3>set, out</h3>
	<c:set var="product1" value="<b>애플 아이폰</b>" />
	<c:set var="product2" value="삼성 갤럭시 노트" />
	<c:set var="intArray" value="${[1,2,3,4,5]}" />
	
	<p>
		product1(jstl):
		<c:out value="${product1}" default="Not registerd" escapeXml="true" />
	</p>
	<p>
		product1(el):${product1} (태그까지 반영)
	</p>
	<p>
		intArray[2]: ${intArray[2]}
	</p>
	<hr>

	<h3>forEach: 배열출력</h3>
	<ul>
		<c:forEach var="num" varStatus="kkk" items="${intArray}">
			<li>${kkk.count}:${num} : ${intArray}</li>
		</c:forEach>
	</ul>
	<hr>
<%-- 	
	<h3>if</h3>
	<c:set var="checkout" value="true"/>
	<c:if test="${checkout}">
		<p>주문제품: ${product2}</p>
	</c:if>
	<c:if test="${!checkout }">
		<p>주문제품이 아님!!</p>
	</c:if>
	<c:if test="${!empty product2}">
		<p>
			<b>${product2} 이미 추가됨!!</b>
		</p>
	</c:if>
	<hr>
	<h3>forTokens</h3>
	<!--<c:forTokens var="city"items="" delims=""></c:forTokens>-->
	 --%>
</body>
</html>