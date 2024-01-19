<%@page import="och10.Dept"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--	dto:data transfer object

dao:data access object 이용 -->
<% 
	
String deptno=request.getParameter("deptno");
String driver="oracle.jdbc.driver.OracleDriver";
String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
String sql="select * from dept where deptno="+deptno;
Class.forName(driver);
Connection conn=DriverManager.getConnection(url,"scott","tiger");
Statement stmt=conn.createStatement();
ResultSet rs=stmt.executeQuery(sql); //select이므로

//dto
Dept dept=new Dept();

if(rs.next()) {
	int deptnoInt=(rs.getInt(1)); //db니까 이게 1번쨰. pk
	String dname=rs.getString("dname");
	String loc=rs.getString(3);
	out.println("부서코드:"+deptno+"<p>");
	out.println("부서명:"+dname+"<p>");
	out.println("근무지:"+loc+"<p>");

	//dept setting
	dept.setDeptno(deptnoInt);
	dept.setDname(dname);
	dept.setLoc(loc);
	request.setAttribute("dept", dept);
} else out.print("부서가 없음");
rs.close();
stmt.close();
conn.close();

RequestDispatcher rd=request.getRequestDispatcher("ora04Result.jsp");
rd.forward(request,response);
	

%>
</body>
</html>