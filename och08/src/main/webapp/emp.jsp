<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="emp" class="och08.Emp" scope="request"></jsp:useBean>


<jsp:setProperty property="empno" name="emp"/>
<jsp:setProperty property="ename" name="emp"/>
<jsp:setProperty property="job" name="emp"/>
<jsp:setProperty property="sal" name="emp"/>
<!-- jsp:setProperty property="*" name="emp" 로 한번에 해도 됨 -->
<!-- 주석인데도 이게 걸렸다. -->


<jsp:forward page="empResult.jsp"></jsp:forward>
</body>
</html>