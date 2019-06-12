<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="dto" class="big06.MemberDTO"></jsp:useBean>
	<jsp:setProperty property="*" name="dto"/>
	<%
		%>

</body>
	<hr color="green">
	id: <%= dto.getId() %><br>
	pw: <%= dto.getPw() %><br>
	name: <%= dto.getName() %><br>
	tel: <%= dto.getTel() %><br>
</html>