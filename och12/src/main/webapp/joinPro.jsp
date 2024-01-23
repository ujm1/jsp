<%@page import="javax.tools.DocumentationTool.Location"%>
<%@page import="och12.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="member2" class="och12.Member2"></jsp:useBean>
<jsp:setProperty property="*" name="member2"/>
<!-- 필드명이 똑같을 때 *... -->
<%
	MemberDao md=MemberDao.getInstance();
	int result=md.insert(member2);
	if(result>0) {
%>		
		<script type="text/javascript">
		alert("회원 가입 성공");
		location.href="loginForm.jsp";
		//이동..
		</script>
<%	}	else { %>
		<script type="text/javascript">
		alert("회원가입 실패");
		location.href="joinForm.jsp";
		</script>
<% } %>
</body>
</html>