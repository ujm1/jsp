<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>1부터 100까지 합 		스플릿틀릿+Expression</h2>
<%	request.setCharacterEncoding("utf-8");
	String num=request.getParameter("num");
	String sum=request.getAttribute("sum").toString();
%>
합2:<%=sum %>
</body>
</html>