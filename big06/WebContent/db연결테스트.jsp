<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javafx.css.PseudoClass"%>
<%@page import="java.sql.DriverManager"%>
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
	String url = "jdbc:mysql://localhost:3306/bigdata";
	String user = "root";
	String password = "1234";
	
		Class.forName("com.mysql.jdbc.Driver");
		out.write("드라이버 설정 ok..");
		Connection con = DriverManager.getConnection(url, user, password);
		
		String sql = "insert into member values(?,?,?,?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		
		
		stmt.setString(1, dto.getId()); 
		stmt.setString(2, dto.getPw());
		stmt.setString(3, dto.getName());
		stmt.setString(4, dto.getTel());
		
		stmt.executeUpdate();
%>
</body>
</html>