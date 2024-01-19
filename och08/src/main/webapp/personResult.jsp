<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="person" class="och08.Person" scope="request"></jsp:useBean>
<!-- Person person=new Person() 과 동일 -->

<jsp:setProperty property="*" name="person"/>
<!-- person.setName("홍길동")과 동일. 단지 여러개를 한꺼번에 가져온것 -->
<h2>인적 사항 personResult</h2>
이름:<jsp:getProperty property="name" name="person"/> <p></p>
성별:<jsp:getProperty property="gender" name="person"/> <p>
나이:<jsp:getProperty property="age" name="person"/>
</body>
</html>