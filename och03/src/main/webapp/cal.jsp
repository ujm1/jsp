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
	int num1=Integer.parseInt(request.getParameter("num1")); 
	int num2=Integer.parseInt(request.getParameter("num2")); 
	out.printf("덧셈:%d+%d=%d<p>",num1,num2,num1+num2);
	out.printf("뺄셈:%d-%d=%d<p>",num1,num2,num1-num2);
	out.printf("곱셈:%d x %d=%d<p>",num1,num2,num1*num2);
	out.printf("나눗셈:%d+%d=%f<p>",num1,num2,(float)num1/num2);
	//jsp에서 이걸 못받는다고 하니.. 해결법은 그냥 int add, min mul div 이렇게 하고
	<%-- 아래 표현식에서 덧셈:<%=add %><p> 이렇게 하나하나 해주는게.  --%>
	<%-- jsp에서 out.printf()는 먹히지 않는다.왜냐하면 out은 javax.servlet.jspWriter 객체인데(내장 객체이다!)이 놈은 printf까지는 지원하지 않는다.
printf를 사용하려면 PrintWriter를 만들어서 쓰면 된다!
<%    PrintWriter pw = response.getWriter();    pw.printf("%d", 123);%>
 --%>
</body>
</html>