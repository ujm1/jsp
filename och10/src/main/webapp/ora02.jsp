
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head><body>
<%
/* 과제: deptno가지고 dept Table 조회: createStatement */
%>

<%
	request.setCharacterEncoding("utf-8");
	String deptno=request.getParameter("deptno");
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String sql=String.format("select * from dept where deptno="+deptno);
	Class.forName(driver);
	Connection conn=DriverManager.getConnection(url,"scott","tiger");
	Statement stmt=conn.createStatement();
	ResultSet rs=stmt.executeQuery(sql);
	if(rs.next()) {
		String dname=rs.getString("dname");
		String loc=rs.getString(3);
		out.println("부서코드"+deptno);
		out.println("부서명"+dname);
		out.println("근무지"+loc);
	} else out.println("부서 없음");
	stmt.close();
	conn.close();

%>
</body>
</html>