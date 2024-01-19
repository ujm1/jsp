<%@page import="java.util.HashMap"%>
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
		HashMap<String,String> map=new HashMap<String, String>();
		map.put("kim", "서울");
		map.put("김","경기");
		
		request.setAttribute("ADDRESS", map);
		RequestDispatcher dispatcher=request.getRequestDispatcher("mapView.jsp?NAME=r");
		dispatcher.forward(request,response);
	%>
</body>
</html>