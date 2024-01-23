<%@page import="java.net.URLDecoder"%>
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
	Cookie cooks[] = request.getCookies(); //보낸 쿠키를 받아와 배열로 저장
	if (cooks != null) {
		for (int i = 0; i < cooks.length; i++) {
			if (cooks[i].getName().equals("name")) { //쿠키의 이름이 name인 쿠키에 대해서
		out.println("쿠키값:" + URLDecoder.decode(cooks[i].getValue(), "utf-8"));
			}								//그 쿠키의 값을 디코딩(다시 한글로..)해 출력
		}      //그래서 쿠키값:중앙정보   <- 가 출력됨
	}
	%>
</body>
</html>