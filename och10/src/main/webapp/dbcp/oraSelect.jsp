<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
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
/* // Hw02
// 1. DBCP 연동
// 2. Emp DTO setter
// 3. oraResult.jsp 이동 */
String empno=request.getParameter("empno");
String sql="select empno, ename, sal, hiredate from emp where empno="+empno;
Context init=new InitialContext(); //흐름, 단계...->처음 실행할 때 설정, 환경...
	DataSource ds=(DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
	

	Connection conn=ds.getConnection();
	if(conn!=null) out.println("연결 성공");
	else out.print("연결실패");
	conn.close();
	%>
</body>
</html>