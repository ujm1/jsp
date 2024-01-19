<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach var="col" items="${color}">
<!--   {"red","orange","yellow","green","blue","navy","violet"} -->
<%-- <font color="${col}">야호</font> --%></c:forEach> 
<jsp:forward page="colorResult2.jsp"></jsp:forward>
</body>
</html>