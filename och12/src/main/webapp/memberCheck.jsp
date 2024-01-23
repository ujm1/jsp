<!-- 이렇게 각 기능별로 잘게 쪼개놓음 -->
<%
String id = (String) session.getAttribute("id");
if (id == null || id.equals("")) {
	response.sendRedirect("loginForm.jsp");
	//아이디가 비었으면 로그인페이지로 이동
}
%>