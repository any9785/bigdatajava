<%@page import="java.util.ArrayList"%>
<%@page import="bean.MemberDAO"%>
<%@page import="bean.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Insert title here</title>
   </head>
   
   <body>
   <%
      //DAO중에서 전체 리스트를 가지고 오는 메서드를 호출
      //반복문으로 테이블내에 tr태그내에 집어넣는다
      MemberDAO dao = new MemberDAO();
      ArrayList<MemberDTO> list = dao.selectAll();
      //제너릭을 쓸때는 꺽쇠로 받아와야 한다
      
   %>
   <center>
      <table border="1" bordercolor="red" width="600">
         <tr align="center">
            <td>아이디</td>
            <td>패스워드</td>
            <td>이름</td>
            <td>연락처</td>
         </tr>
         <%for(int i = 0 ; i < list.size() ; i++) {
             MemberDTO dto = list.get(i);
         %>
         <tr align="center">
            <td>
            <a href="find.jsp?id=<%=dto.getId() %>"><%= dto.getId() %></a></td>
            <td><%=dto.getPw() %></td>
            <td><%=dto.getName() %></td>
            <td><%=dto.getTel() %></td>
         </tr>
         <%} %>
      </table>
   </center>
   
   </body>
</html>