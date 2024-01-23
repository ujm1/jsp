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
	<!-- Service -->
	<%
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	MemberDao md = MemberDao.getInstance();
	//싱글턴 이용. memberDao 만들어 쓰는건 똑같고.. 단지 싱글턴으로 쓰느냐 아니냐의 차이

	int result = md.insert(member2);
	//preparedStatement사용
	if (result == 1) {
		session.setAttribute("id", id);
		response.sendRedirect("main.jsp");
		//로그인했을 경우 메인화면으로 이동
	} else if (result == 0) {
	%>
	<script type="text/javascript">
		alert("암호를 알 수 없습니다");
		history.go(-1);
	</script>



	<%
	} else {
	%>
	<script type="text/javascript">
		alert("user 미존재 -1");
		history.go(-1);
	</script>

	<%
	}
	%>




</body>
</html>