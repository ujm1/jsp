<%@page import="och12.Member2"%>
<%@page import="och12.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="error.jsp"%>
<%@ include file="memberCheck.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	background-color: pink;
}
</style>
</head>
<body>
	<%
	MemberDao md = MemberDao.getInstance();
	Member2 member = md.select(id);
	
	String context = request.getContextPath();
	//스프링 부분
	%>
	<h2>회원 정보 수정</h2>
	<form action="updatePro.jsp">
		<table border="1" id="table">
			<tr>
				<td>아이디</td>
				<td><%=id%><input type="hidden" class="id" name="id" id="id"
					value="<%=member.getId()%>"></td>
					<!-- id는 수정하지 않을 것이므로 value로 원래값 가져오게 해 
					보여주기는 하되, 쓰지는 못하게 hidden으로 -->
			</tr>
			<tr>
				<td>암호</td>
				<td><input type="password" name="passwd" required="required">
				<!-- 암호는 직접 입력하도록, 자동완성값(value)가져오지 않음 -->
				</td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" id="name"
					required="required" value="<%=member.getName()%>"></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="address" required="required"
					value="<%=member.getAddress()%>"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="tel" name="tel" required="required"
					pattern="\d{2,3}-\d{3,4}-\d{4}" value="<%=member.getTel()%>">
				</td>
			</tr>
			<tr>
				<td>날짜</td>
				<td><%=member.getReg_date()%></td>
				<!-- 날짜는 변경 못하게 할 것이므로 input을 넣지 않음 -->
			</tr>
			<tr>
				<td><input type="submit" value="확인"></td>
				<td><input type="reset" value="취소"></td>
			</tr>
		</table>

	</form>
</body>
</html>