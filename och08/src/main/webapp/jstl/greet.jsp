<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<c:set var="greet" value="How Are you ?"></c:set>
<body>
	원글:${greet} <p></p>
	대문자:${fn:toUpperCase(greet)} <p>
	소문자:${fn:toLowerCase(greet)}<p>
	How 위치: ${fn:indexOf(greet,"How")}<p><!--0 -->
	Are 위치:${fn:indexOf(greet,"Are")}<p> <!--4 -->
	Are 변경:${fn:replace(greet,"Are","Were")}<p>
	문자 길이:${fn:length(greet)}<p><!--13 -->
	<!--즉 문자열로 받는다. set은.. -->
	<!--그러나 이건 자동완성이 안되는 문제점 -->
</body>
</html>