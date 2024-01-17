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
request.setCharacterEncoding("utf-8");
int num=Integer.parseInt(request.getParameter("num"));
int sum=0;
for(int i=0; i<=num; i++) {sum+=i;}
out.println("1부터"+num+"까지의 합:"+sum);
%>
<!-- 오류 -->
</body>
</html>