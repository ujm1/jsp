<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:set var="date" value="<%=new Date()%>"></c:set>
</head>
<body>
서울: <fmt:formatDate value="${date}" type="both"/> <br>
<!--서울: 2024. 1. 19. 오후 12:09:37 -->

<fmt:timeZone value="Asia/Hong_Kong">
홍콩: <fmt:formatDate value="${date}" type="both"/>
</fmt:timeZone>
<!--여기부터도. 이제 각각... 출력 -->
<fmt:timeZone value="Europe/London">
런던: <fmt:formatDate value="${date}" type="both"/> <br>
</fmt:timeZone>

<fmt:timeZone value="America/New_York">
뉴욕: <fmt:formatDate value="${date}" type="both"/>
</fmt:timeZone>
</body>
</html>