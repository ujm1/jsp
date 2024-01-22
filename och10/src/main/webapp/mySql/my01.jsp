<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
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
String driver = "com.mysql.cj.jdbc.Driver" ;
//커넥터 jar 를 lib에 넣고 재실행해서 띄워야
String url    = "jdbc:mysql://localhost:3306/scottdb?serverTimezone=UTC";
//oracle 이 아닌...mysql에 연결하기.
Class.forName(driver);
Connection conn=DriverManager.getConnection(url,"root","mysql80@");
if(conn!=null) {out.println("mysql연결성공");}
else out.println("mysql연결실패");
conn.close();
%>
</body>
</html>