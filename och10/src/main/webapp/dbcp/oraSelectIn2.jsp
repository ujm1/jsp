<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
//1. dbcp 
//2. arraylist al -> emp (emp,ename) -> 아래에 뿌려줌


%>
<h2>보고 싶은 사원 번호를 선택하세요</h2>
<form action="oraCallEmpInfo.jsp">
	<select name="empno">
		<c:forEach var="emp" items="${al}">
			<option value="${emp.empno}">${emp.empno} ${emp.ename}</option>
		</c:forEach>
	</select><p>
	<input type="submit" value="선택완료">
</form>
</body>
</html>