<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:catch var="el">
	<%
		int num1=Integer.parseInt(request.getParameter("num1"));
	int num2=Integer.parseInt(request.getParameter("num2"));
	%>
	나눗셈 결과: <%=(float)num1/num2 %>
	</c:catch>
	
	<c:if test="${el!=null}">
	에러메시지: ${el.message}
	</c:if>
	
	
</body>
</html>