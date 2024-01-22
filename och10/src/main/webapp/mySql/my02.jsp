<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
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
	String dno=request.getParameter("dno");
	String driver="com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/scottdb?serverTimezone=UTC";
	String sql="select * from division where dno="+dno;
	Class.forName(driver);
	Connection conn=DriverManager.getConnection(url,"root","mysql80@");
	Statement stmt=conn.createStatement();
	ResultSet rs=stmt.executeQuery(sql);
	if(rs.next()) {
		String dname=rs.getString("dname");
		String phone=rs.getString(3);
		String position=rs.getString(4);
		out.println("부서코드"+dno+"<p>"+"부서명"+dname+"<p>"+"전화번호"+phone+"<p>"+"근무지"+position);
		
		
	} else out.print("부서 없음");
	rs.close();
	stmt.close();
	conn.close();
	
%>
</body>
</html>