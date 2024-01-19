<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--  자바 bean은 특정 형태의 클래스. -->
<%-- <jsp:useBean id="pt" class="och08.Book"/> --%>
<jsp:useBean id="pt" class="och08.Book" scope="request"/>
<!-- 자바빈의 기본 scope는 page이며, 요청하는 것 끝까지 가려면 request -->
<!-- 저 자바 클래스를 pt라고 해서 가져온다 -->

<!-- bean값 저장 -->
<jsp:setProperty property="*" name="pt"/>
<!-- * = 전체 한번에 -->

<!--bean 값 가져오기  -->
<jsp:getProperty property="code" name="pt"/><p>
<jsp:getProperty property="name" name="pt"/><p>
<jsp:getProperty property="price" name="pt"/><p>
<!-- 이러면 Book.java에서 설정한 게터와 세터를 쓸 수 있다...
정확히는 pt 즉 Book으로 가고, Book 위의 Product로 가서, 거기서 설정한
code name price를 가져오는?

<!-- 1. 필드는 private로 구성  -->
  <!-- 2. getter와 setter를 통해서만 접근  -->
  <!-- 3. 전달 인자가 없는( no-argument)  생성자로 구성  -->  
 
 <jsp:forward page="productInfo.jsp"></jsp:forward>
 <!-- 위의 scope를 request로 해줘야 여기까지 간다. -->
</body>
</html>