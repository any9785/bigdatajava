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
		String travel = request.getParameter("travel");
		int count = Integer.parseInt(request.getParameter("count"));
		if(count >= 3){
			out.print(travel + "를 그만 가셔야겠군요.");
		}else{
			out.print(travel + "을 더 갈수도 있겠군요.");	
		}
		%>
	</body>
</html>