<%@page import="java.sql.CallableStatement"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.sql.Types"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% //프로시저 	
	int empno=Integer.parseInt(request.getParameter("empno"));
	System.out.println("empno->"+empno);
	Context ctx=new InitialContext();
	DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/OracleDB");
	Connection conn=ds.getConnection();
	
	/* 프로시저는...
	create or replace PROCEDURE Emp_Info3
(p_empno IN emp.empno%TYPE, p_sal OUT emp.sal%type)
is
v_empno emp.empno%type;
v_ename emp.ename%type;

begin
    dbms_output.enable;
    select empno, ename, sal
    into v_empno, v_ename, p_sal
    from emp
    where empno=p_empno;
    
    dbms_output.put_line('사원번호:'||v_empno);
    dbms_output.put_line('사원이름:'||v_ename);
end; */
	
	String sql="{call Emp_info3(?,?)}";
	CallableStatement cs=conn.prepareCall(sql);
	cs.registerOutParameter(2,Types.DOUBLE);
	//PROCEDURE문에 OUT으로 정의된 매개변수의 데이터 유형을 등록
	cs.setInt(1,empno);
	cs.execute();
	out.println(cs.getDouble(2));
	cs.close();
	conn.close();
	//사번코드 7369 넣으면 그 직원의 salary인 800이 double인 800.0으로 출력
%>
</body>
</html>