<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>		
<!-- 앞서한것과 달리 따로 선언해서 가져올 필요 없이 여기서 집합 설정 -->
	<c:set var="animals" value="토끼,고양이*강아지, 여우"></c:set>
	<h2>사자의 생일</h2>  <!-- 토끼, 고양이 ///강아지, 여우라는 의미 -->
	<c:forTokens var="an" items="${animals}" delims="*">
		${an} <br>                      <!-- delims는 구분자 -->
	</c:forTokens>
</body>
</html>