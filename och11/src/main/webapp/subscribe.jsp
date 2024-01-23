<%@page import="och11.MemberDao"%>
<%@page import="och11.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="dbError.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String chk = "";
	String agree = request.getParameter("agree"); //앞서서 agree했는지 보려고
	if (agree.equals("y")) {//앞서서 agree에서 y를 보냈다면..
		String id = (String) session.getAttribute("id"); //세션의 name인 id의 값인 name을 문자열로 해서 id라고 지정(여기서 출력하기 위해)
		String password = (String) session.getAttribute("password");
		String name = (String) session.getAttribute("name");
		System.out.println("subscribeid" + id);
		System.out.println("subscribepassword" + password);
		System.out.println("subscribename" + name);
		/*  chk = "success"; 하면 되는데, 이럴경우 db테이블에 추가되지 않음. 
		memberdao와 memberdto만들었고 이를 활용해서 하기 :
			
		*/
		MemberDto member = new MemberDto();
		member.setId(id);
		member.setName(name);
		member.setPassword(password);

		MemberDao md = new MemberDao();
		int result = md.insert(member);
		if (result > 0)
			chk = "success";
		else
			chk = "fail";

	} else
		chk = "fail";

	session.invalidate();
	out.print("invalidate() 적용 후에도" + session.getId() + "<br>");
	response.sendRedirect("result.jsp?chk=" + chk); //chk의 값을 갖고 리다이렉트(이동)
	%>
</body>
</html>