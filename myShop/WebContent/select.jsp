<%@page import="product.ProductDTO"%>
<%@page import="product.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
      <head>
         <meta charset="UTF-8">
         <title>Insert title here</title>
      </head>
   <body>
      <jsp:useBean id="dto" class="product.ProductDTO"></jsp:useBean>
      <jsp:setProperty property="*" name="dto"/>
      <%
      ProductDAO dao = new ProductDAO();
      ProductDTO dto1 = dao.select(dto);
      %>
      <table>
         <tr>
            <th>아이디ㅣ</th>
            <th>상품제목ㅣ</th>
            <th>상품설명ㅣ</th>
            <th>가격ㅣ</th>
         </tr>
         <tr>
            <th><%= dto1.getId() %></th>
            <th><%= dto1.getProduct() %></th>
            <th><%= dto1.getContent() %></th>
            <th><%= dto1.getPrice() %></th>
         </tr>
      </table>
   </body>
</html>