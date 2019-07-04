<%@page import="product.ProductDTO"%>
<%@page import="product.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
      <head>
         <meta charset="UTF-8">
         <title>Insert title here</title>
         <link rel="stylesheet" type="text/css" href="product.css">
      </head>
   <body>
      <jsp:useBean id="dto" class="product.ProductDTO"></jsp:useBean>
      <jsp:setProperty property="*" name="dto"/>
      <%
      ProductDAO dao = new ProductDAO();
      dao.update(dto);
      %>
      <form action="update.jsp">
      <div>
         수정 할 아이디:<input type="text" name="id"><br>
         수정 할 상품내용:<input type="text" name="content"><br>
         수정 할 가격:<input type="text" name="price"><br>
         <button type="submit">수정</button>
      </div>
      </form>
      
   </body>
</html>