<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<% //파라미터 받기 
String color=request.getParameter("color");
%>
<body bgcolor="<%=color%>">

</body>
</html>