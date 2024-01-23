<%@page import="oracle.net.aso.r"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="och10.Professor"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	ArrayList<Professor> al=new ArrayList<Professor>();
	Context ctx=new InitialContext();
	DataSource ds=(DataSource) ctx.lookup("java:comp/env/jdbc/MySql");
	Connection conn=ds.getConnection();
	Statement stmt=conn.createStatement();
	String sql="select profno, name from professor";
	ResultSet rs=stmt.executeQuery(sql);
																//sql이 없다
	if(rs.next()) {
		do{
			Professor professor=new Professor();
			professor.setProfno(rs.getInt(1));
			professor.setName(rs.getString(2));
			al.add(professor);
		} while(rs.next());
		request.setAttribute("al", al);
		rs.close();
		stmt.close();
		conn.close();
	} else {
		out.println("데이터가 없습니다");
		stmt.close();
		conn.close();
	}
	

%>
<h2>보고싶은 교수 번호를 선택하세요</h2>
<form action="mySelect.jsp">
	<select name="pno">
	<c:forEach var="professor" items="${al}">
		<option value="${professor.profno}"> ${professor.profno} 
		${professor.name} </option>
	</c:forEach></select>
	</form>
</body>
</html>