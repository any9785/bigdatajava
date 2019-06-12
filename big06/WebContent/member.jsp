<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
   <body>
   <!-- 선언문: 전역변수사용 -->
   <!-- 스크립트릿 : 자바코드가 들어가는 부분.(service())->지역변수 -->
   <!-- 메소드 정의 할 수 없음. 전역변수 사용 불가  -->
      <% 
         String id = request.getParameter("id");
         String pw = request.getParameter("pw");
         String name = request.getParameter("name");
         String tel = request.getParameter("tel");
         String[] hobby = request.getParameterValues("hobby");
         String result = "";
         for(int i = 0; i < hobby.length; i++){
        	 result = result + hobby[i] + " ";
         }
      %>
      <h3>당신이 입력한 정보는 아래와 같습니다.</h3>
      <hr color="blue">
      HOBBY = <%= result %><br><!-- 표현식(Expression):변수값 출력, 연산결과, 메소드호출반환값 -->
          표현식 연결결과 출력: <%= 100 + 200 %><br>
      ID: <%= id %><br>
      PW: <%= pw %><br>
      NAME: <%= name %><br>
      TEL: <%= tel %><br>
</body>
</html>