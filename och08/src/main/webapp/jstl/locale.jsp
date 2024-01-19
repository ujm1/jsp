<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<c:set var="date" value="<%=new Date()%>"></c:set>
<body>

	<h2>우리나라</h2>
	<fmt:setLocale value="ko_kr" />
	금액:
	<fmt:formatNumber value="1000000" type="currency">
	</fmt:formatNumber>
	<br>
	<!-- 금액: ₩1,000,000 -->

	일시:
	<fmt:formatDate value="${date}" type="both" dateStyle="full"
		timeStyle="full" />
	<!-- 일시: 2024년 1월 19일 금요일 오전 11시 53분 38초 대한민국 표준시 -->
	<br>

	<h2>미국</h2>
	<fmt:setLocale value="en_us" />
	금액:
	<fmt:formatNumber value="1000000" type="currency">
		<!-- 금액: $1,000,000.00 -->
	</fmt:formatNumber>
	<br> 일시:
	<fmt:formatDate value="${date}" type="both" dateStyle="full"
		timeStyle="full" />
	<!-- 일시: Friday, January 19, 2024 at 11:53:38 AM Korean Standard Time -->
	<br>

	<h2>일본</h2>
	<fmt:setLocale value="ja_jp" />
	금액:
	<fmt:formatNumber value="1000000" type="currency">
	</fmt:formatNumber>
	<br>
	<!-- 금액: ￥1,000,000 -->
	일시:
	<fmt:formatDate value="${date}" type="both" dateStyle="full"
		timeStyle="full" />
	<!-- 일시: 2024年1月19日金曜日 11時53分38秒 韓国標準時 -->
	<br>

</body>
</html>