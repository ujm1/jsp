<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Form은 param으로 받음</h1>
	첫번째 동물:${param.an1}<br>
	두번째 동물:${param.an2}<br>
	같은 동물:${param.an1==param.an2 }<br>
	<!--  이런 식으로 스크립틀릿 열고 닫지 않아도 받아올 수 있다.--> 
</body>
</html>