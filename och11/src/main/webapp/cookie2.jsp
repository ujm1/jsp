<%@page import="com.oracle.wls.shaded.org.apache.bcel.generic.LLOAD"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 						/* 쿠키의 네임이 name, value가 "중앙정보라는걸 코드화해서 값으로 한 것"이 됨. */
	Cookie cook2=new Cookie("name", URLEncoder.encode("중앙정보","utf-8"));
	response.addCookie(cook2); //쿠키로 추가.
%>
쿠키저장성공 <br> <a href="cookView2.jsp">쿠키 보기..</a>
</body>
</html>