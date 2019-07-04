<%@page import="product.ProductDTO"%>
<%@page import="product.ProductDAO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
   <body>
      <jsp:useBean id="dto" class="product.ProductDTO"></jsp:useBean>
      <jsp:setProperty property="*" name="dto"/>
      <table>
         <tr>
            <th>아이디</th>
            <th>상품제목</th>
            <th>상품설명</th>
            <th>가격</th>
         </tr>
         
      <%
      ProductDAO dao = new ProductDAO();
      ArrayList list = null;
      list = dao.selectAll(dto);
      for(int i = 0; i < list.size(); i++){
         dto = (ProductDTO)list.get(i);
         String id = dto.getId();
         String product = dto.getProduct();
         String content = dto.getContent();
         String price = dto.getPrice();
      %>      
         <tr>
            <th><%= id %></th>
            <th><%= product %></th>
            <th><%= content %></th>
            <th><%= price %></th>
         </tr>
      <%}%>
      </table>
   </body>
</html>