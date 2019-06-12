<%@page import="bean.MemberDTO"%>
<%@page import="bean.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 액션태그 -->
<jsp:useBean id="dto" class="bean.MemberDTO"></jsp:useBean>
<jsp:setProperty property="*" name="dto"/>
<% /* 스크립트릿 */
	//자동 import 컨트롤+쉬프트+m
	MemberDAO dao = new MemberDAO();
	MemberDTO dto2 = dao.select(dto);
%>
검색결과입니다.
<hr>
<form action="update.jsp">
	수정할 ID : <input type="text" name="id" value=<%= dto2.getId() %> readonly="readonly"><br> <!-- 표현식(Expression) -->
	수정할 PW : <input type="text" name="pw" value=<%= dto2.getPw() %>><br>
	수정할 NAME : <input type="text" name="name" value=<%= dto2.getName() %>><br>
	수정할 TEL : <input type="text" name="tel" value=<%= dto2.getTel() %>><br>
	<button type="submit" class="btn btn-success">서버로 전송</button>
</form>
</body>
</html>