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
<form action="oraUpdate.jsp">
	부서코드:${deptno} <p>
	<input type="hidden" name="deptno" value="${deptno}">
	<!-- hidden으로 한 이유 : pk는 수정 안하는게 일반적이므로, hidden으로 해준다
	hidden으로 하면 값이 표기는 되되 텍스트 상자로 수정할 수 없다.-->
	부서명: <input type="text" name="dname" value="${dname}">
	근무지: <input type="text" name="loc" value="${loc}">
	<input type="submit" value="수정완료"> 
</form>
</body>
</html>