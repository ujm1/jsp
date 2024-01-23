<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
//1. dbcp 
	Context init=new InitialContext(); 
	DataSource ds=(DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
		
	Connection conn=ds.getConnection();
	if(conn!=null) out.println("연결 성공");
	else out.print("연결실패");
	conn.close();

//2. arraylist al -> emp (emp,ename) -> 아래에 뿌려줌
ArrayList<Emp> al=new ArrayList<Emp>();
	Statement stmt=conn.createStatement();
	ResultSet rs=stmt.executeQuery(sql);
																//sql이 없다
	if(rs.next()) {
		do{
			Emp emp=new Emp();
			emp.setEmpno(rs.getInt(1));
			emp.setEname(rs.getString(2));
		} while(rs.next());
		request.setAttribute("al", al);
		rs.close();
		stmt.close();
		conn.close();
	RequestDispatcher rd= request.getRequestDispatcher("oraCallEmpInto .jsp");
		rd.forward(request, response);
	} else {
		out.println("데이터가 없습니다");
		stmt.close();
		conn.close();
	}

%>
<h2>보고 싶은 사원 번호를 선택하세요</h2>
<form action="oraCallEmpInfo.jsp">
	<select name="empno">
		<c:forEach var="emp" items="${al}">
			<option value="${emp.empno}">${emp.empno} ${emp.ename}</option>
		</c:forEach>
	</select><p>
	<input type="submit" value="선택완료">
</form>
</body>
</html>