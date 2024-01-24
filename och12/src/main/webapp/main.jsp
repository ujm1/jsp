<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="memberCheck.jsp"%>
<!-- 먼저 여기부터 간다 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

</head>

<body>
	<h2>회원 관리 메뉴</h2>
	<%=id%>님 환영합니다
	<!-- 이 id는 위의 memberCheck에서 받음 -->
	<br>
		<!-- 로그인 된 상태 -->
<div class="btn-group">
     <a href="logOut.jsp" class="btn btn-primary active btn-lg" aria-current="page">로그아웃</a>
     <a href="joinForm.jsp" class="btn btn-primary btn-lg">회원가입</a>
     <a href="joinForm3.jsp" class="btn btn-primary btn-lg">회원가입(image)</a>
     <a href="memberList.jsp" class="btn btn-primary btn-lg">회원명단</a>
     <a href="updateForm.jsp" class="btn btn-primary btn-lg">회원정보수정</a>
     <a href="updateForm3.jsp" class="btn btn-primary btn-lg">회원정보수정(image)</a>
     <a href="deleteForm.jsp" class="btn btn-primary btn-lg">회원탈퇴</a>
   </div>
    <div >
           <img alt="회원이미지1" src="image/back2.jpeg"><br>
    </div>
    <div id="footer">
       <h2>푸터</h2>
      <p> 모든 저작권은 중앙정보처리 회사에 있습니다 </p>
      <p> 02-333-5678 </p>   
    
    </div>
</body>
</html>