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
pageContext.setAttribute("sum", sum);
 RequestDispatcher rd=request.getRequestDispatcher("hunResultEl3.jsp"); 
 rd.forward(request, response); //이쪽으로 가서

%>
같은 페이지: ${sum} //이건 안나온다.
</body>
</html>