<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	int sum=0;
	for(int i=0; i<=100; i++) {
		sum+=i;
	}
	request.setAttribute("sum", sum);
	/* RequestDispatcher rd=request.getRequestDispatcher("hunResult.jsp"); */
	RequestDispatcher rd=request.getRequestDispatcher("hunResultEl.jsp");
	rd.forward(request, response);
	//이러면 바로 hunResult.jsp의 내용이 출력됨.
%>
</body>
</html>