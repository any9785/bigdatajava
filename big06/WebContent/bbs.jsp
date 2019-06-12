<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="dto" class="big06.bbsDTO"></jsp:useBean>
<jsp:setProperty property="*" name="dto"/>
</body>
	DTO에 들어간 값 출력
	<hr color="green">
	id: <%= dto.getId() %><br>
	title: <%= dto.getTitle() %><br>
	content: <%= dto.getContent() %><br>
	writer: <%= dto.getWriter() %><br>
</html>