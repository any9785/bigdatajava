<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 선언문 -->
	<%!
	String name; //전역변수
	public String test(){
		return 1000 + "원";
	}
	%>
	 <!-- 스크립트릿 --> 
	<%
	String test = ""; //지역변수
	/* 	printWriter out = new PrintWriter(); */
	out.print(100 + 200 + "<br>");
	%>
	<!-- 표현식(세미콜론X) -->
	<%= 100 + 200 %><br>
	<%= name %>, <%= test %><br>
	<%= test() %>
</body>
</html>