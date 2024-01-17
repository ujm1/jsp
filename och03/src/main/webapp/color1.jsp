<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<% String color=request.getAttribute("color").toString(); %>
						<!-- 파라미터가 아니라 attribute로. set으로 했으니 get으로.
						그리고 string으로. toString 없으니 Object(배열?) 타입  -->
<body bgcolor="<%=color%>">

</body>
</html>