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
String[] col={"red","orange","yellow","green","blue","navy","violet","black"};

int n=(int)(Math.random()*8); //0~7
String pgm=request.getParameter("pgm")+".jsp";
//form으로 보낸거니 getParameter로.

RequestDispatcher rd=request.getRequestDispatcher(pgm);
//form없이 이름 Page를 지정하는 객체
//어느 페이지로 이동할지 지정

if(pgm.equals("color1.jsp")) { //이동 페이지 주소가 이거면
	request.setAttribute("color", col[n]);
			//form문을 통하지 않고 파라미터에 넘겨주는 메소드
			//col[n]의 값을 color에 넣어서 보냄
			//즉 다른 페이지, 내가 만든, color.jsp로 보낼 수 있다. 이렇게 .jsp 붙여서

} else if  (pgm.equals("gugu1.jsp")) {
	request.setAttribute("num", n+2); //2~9
}else if  (pgm.equals("response.jsp")) {
	
}
rd.forward(request,response);
//페이지로 이동





%>
</body>
</html>