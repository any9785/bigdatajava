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
         String id = request.getParameter("id");
         String pw = request.getParameter("pw");
         String name = request.getParameter("name");
         String tel = request.getParameter("tel");
         String birth = request.getParameter("birth");
         String month = request.getParameter("month");
         String day = request.getParameter("day");
         String gender = request.getParameter("gender");
         String email = request.getParameter("email");
      %>
      <h3>당신이 입력한 정보는 아래와 같습니다.</h3>
      <hr color="blue">
      ID: <%= id %><br>
      PW: <%= pw %><br>
      NAME: <%= name %><br>
      TEL: <%= tel %><br>
      BIRTH: ${param.birth} ${param.month} ${param.day}<br>
      GENDER: ${param.gender}<br>
      EMAIL: ${param.email}<br>

</body>
</html>