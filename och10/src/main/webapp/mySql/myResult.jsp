<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>부서 정보 수정</h2>
<form action="myUpdate.jsp">
부서코드: ${deptno}<input type="hidden" name="deptno" value="${deptno}"> <br>
부서명:<input type="text" name="dname" value="${dname}"> <br>
전화번호:<input type="text" name="phone" value="${phone}"> <br>
근무지:<input type="text" name="position" value="${poisition}"> <br>
<input type="submit" value="확인"></form>
</body>
</html>