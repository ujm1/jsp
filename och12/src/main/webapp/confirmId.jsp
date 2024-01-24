<%@page import="och12.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>	<!--아이디체크 눌렀을 때 나오는 페이지 -->
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%	String id=request.getParameter("id");%>
<script type="text/javascript">
	function wincl() {
		opener.document.frm.id.value="<%=id%>";
		window.close(); /* 전 페이지에서 id 받아와 js에서 사용 */
	}
</script>
</head>
<body>
<%
	MemberDao md=MemberDao.getInstance();
int result=md.confirm(id); //동일한 id 있는지 체크
if(result==0) {	//id가 없으면
%>
	<%=id %>는 사용할 수 있습니다 <br>
	<input type="button" value="닫기" onclick="wincl()">
<% } else { //id가 있으면
	 %>
	 <%=id %>이미 있는 아이디니 다른 것을 입력하세요 <br>
	 <form>
	 	아이디: <input type="text" name="id"> <br>
	 	<input type="submit" value="확인">
	 </form>
<% } %>
</body>
</html>