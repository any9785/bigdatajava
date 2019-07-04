<%@page import="product.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="css.css"/>
</head>
   <body>
   	<input type="button" value="등록"  class="btn btn-danger" onclick="location.href='insert.html'"></button>
	<input type="button" value="삭제" class="btn btn-warning" onclick="location.href='delete.jsp'"></button>
	<input type="button" value="수정" class="btn btn-success" onclick="location.href='update.html'"></button>
	<input type="button" value="검색" class="btn btn-info" onclick="location.href='select.html'"></button>
      <jsp:useBean id="dto" class="product.ProductDTO"></jsp:useBean>
      <jsp:setProperty property="*" name="dto"/>
      <%
      ProductDAO dao = new ProductDAO();
      dao.delete(dto);
      %>      
      <form action="delete.jsp">
      <h1>상품 삭제하기</h1><hr>
      <div class="remove">
            삭제할 아이디 입력
      </div>
      <div class="badge badge-primary text-wrap" style="width: 12rem;">
      	<div class="text">
	  		<input type="text" name="id">
	  	</div>
	  </div>
	  <br>
      <button type="submit">삭제</button>
      </form>
   </body>
</html>