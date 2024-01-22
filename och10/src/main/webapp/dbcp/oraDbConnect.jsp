<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="java.net.ConnectException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="../dbError.jsp"%>
<!DOCTYPE html>					<!-- ../ : 부모디렉토리. cd ..와 동일 -->
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>dbcp 연결</h2>
<%
	Context init=new InitialContext(); //흐름, 단계...->처음 실행할 때 설정, 환경...
	DataSource ds=(DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
	//이렇게 해서 , DBCP 써서 데이터 소스에 담음. 그 안에 다 있으니까, 복잡한 작업 할 필요없이
	//세팅이 완료되었으므로, 그냥 갖다 쓸 수 있다.
	
	Connection conn=ds.getConnection();
	if(conn!=null) out.println("연결 성공");
	else out.print("연결실패");
	conn.close();
	//단일페이지로 연결
	
	%>
</body>
</html>