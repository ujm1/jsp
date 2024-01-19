<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

${param.NAME}의 주소는? ${ADDRESS[param.NAME]} <p></p>
${ADDRESS.김} <p></p>  <!-- 한글 못 받아 오류. -->
${ADDRESS["김"]} <p>





</body>
</html>