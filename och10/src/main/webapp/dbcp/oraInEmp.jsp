<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>사번정보 입력</h2>
<!-- <form action="oraSelect.jsp" method="post"> -->
<form action="oraCallEmpInfo.jsp" method="post">
	사번코드: <input type="number" name="empno" required="required">
	<input type="submit" value="입력완료">
	<input type="reset" value="입력취소">
</form>
</body>
</html>