<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="style.css">
<style type="text/css">
table {
	width: 80%;
}
</style>
</head>
<body>
	<table border="1">
		<caption>
			<h2>게시판 상세내역 ${board.num}</h2>
		</caption>
		<tr>
			<td width="50">번호</td>
			<td>${board.num}</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${board.writer}</td>
		</tr>
		<tr>
			<td>작성일</td>
			<td>${board.reg_date}</td>
		</tr>
		<tr>
			<td>조회수</td>
			<td>${board.readcount}</td> <!--글 클릭할 시 조회수 증가 -->
		</tr>
		<tr>
			<td>ip</td>
			<td>${board.ip}</td>
		</tr>
		<tr>
			<td>이메일</td>
			<td>${board.email}</td>
		</tr>
		<tr>
			<td>내용</td>
			<td><pre>${board.content}</pre></td>
		</tr>
		<tr>	
			<td colspan="2"> <!--col(열) 2개를 합쳐 1개로 만들고 그 안에 아래의 버튼들 넣는 것 -->
			<input type="button" value="수정"
				onclick="location.href='updateForm.do?num=${board.num}&pageNum=${pageNum}'">
				<input type="button" value="답변작성"	
				onclick="location.href='writeForm.do?num=${board.num}&pageNum=${pageNum}'">
				<input type="button" value="삭제"
				onclick="location.href='deleteForm.do?num=${board.num}&pageNum=${pageNum}'">
				<input type="button" value="목록"
				onclick="location.href='list.do?pageNum=${pageNum}'">
				<!-- num, pageNum을 전페이지에서 request.setAttribute로 보내기에 가능 -->
			</td>
		</tr>
	</table>
</body>
</html>