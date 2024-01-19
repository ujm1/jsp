<!--lib에 ojdbc6.jar 넣은 상태
mysql-connector-j=8.3.0.jar는 지금 쓰이지 않음 -->
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	Class.forName(driver);//로딩					//sid : 서비스 id:여기선 xe
	Connection conn = DriverManager.getConnection(url, "scott", "tiger");
	//객체 생성
	if (conn != null)
		{out.println("연결 성공");}
	else {out.println("연결 실패");}
	conn.close();
	%>
	<!--자바에서 연결하던 것처럼.
	statement 쓰면 -->
</body>
</html>