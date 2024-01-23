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
String chk=request.getParameter("chk"); //chk값 받아옴
	
	//http://localhost:8181/och11/result.jsp?chk=success로 이동
	if (chk.equals("success"))
		out.print("축하합니다 회원가입");

	//http://localhost:8181/och11/result.jsp?chk=fail로 이동
	else
		out.print("회원가입 실패");
%>
</body>
</html>