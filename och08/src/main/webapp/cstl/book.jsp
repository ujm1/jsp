<!--커스텀 스탠다드 태그 라이브러리. 라서 cstl. 임의로 web-inf 폴더 안에 tags 폴더 만들고 그 안에 other->web->tag 파일 만들어서 템플릿처럼 자동완성 사용사용 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>좋아하는 책</h2>
	<u:newLine color="red" size="23" /> <!--tag에서 설정한 것처럼 빨간 선 -->
	<p>
		홍길동전 <br> 이순신전 <br> 김유신전 <br>
		<u:newLine color="blue" size="27" /> <!--파란 선 -->
</body>
</html>