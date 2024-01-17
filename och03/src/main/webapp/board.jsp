<%@page import="java.io.FileWriter"%>
<%@page import="java.util.Date"%>
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
	request.setCharacterEncoding("utf-8");
	//request, response 등은 내장 객체로 이렇게 만들지 않고 바로 쓸 수 있다.
	String title=request.getParameter("title");
	String writer=request.getParameter("writer");
	String content=request.getParameter("content");
	Date date=new Date();
	
	long fileName=date.getTime();
	
	//내장 파일 저장 단계
	String real=application.getRealPath("/WEB-INF/out/"+fileName+".txt");
	
	System.out.println(real);
	
	FileWriter fw=new FileWriter(real);
	//처음 할때는 out이라는 폴더가 없어서 저 경로를 못찾으므로 직접 폴더를 만들어줘야한다.
	//그러면 저 위치에 저걸 이름으로 하는 파일을 만든다.
	String msg="제목: "+title+"\r\n"; //return+line feed. 캐리지리턴cr+lf. 줄바꿈
	msg+="작성자:"+writer+"\r\n";
	msg+="내용:"+content+"\r\n";
	fw.write(msg);
	fw.close();
	//이렇게 파일의 내용을 넣을 수 있다.
	
	//그리고 이제 브라우저 출력 단계
	out.println("제목1:"+title+"<p>");
	//out도 내장 객체. 간편함을 위해 이렇게 만들어놓았음.
	out.println("작성자1"+writer+"<p>");
/* 	out.println("작성일1:"+date+"<p>"); */
	out.println("내용1"+content+"<p>");

%>

제목2: <%=title%> <p>
작성자2: <%=writer%> <p>
내용2: <%=content%> <p>
</body>
</html>