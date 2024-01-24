<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function chk() {//비밀번호 확인
		if (frm.passwd.value != frm.passwd2.value) {
			alert("암호가 다릅니다");
			frm.passwd.focus();
			return false;
		}
		return true;
	}
	function winop() {//아이디 체크 누를 시 
		if(!frm.id.value) {
			alert("id를 입력하고 사용하세요");
			frm.id.focus();
			return false;
		}
		window.open("confirmId.jsp?id="+frm.id.value, "kkk", "width=300 height=300");
					//윈도우 띄우며 이 페이지로 이동
	}
</script>
</head>
<body>
	<form action="joinPro.jsp" name="frm" onsubmit="return chk()">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" required="required"> <input
					type="button" value="아이디체크" onclick="winop()"></td>
			</tr>
			<tr>
				<td>암호</td>
				<td><input type="password" name="passwd" required="required">
				</td>
			</tr>
			<tr>
				<td>암호확인</td>
				<td><input type="password" name="passwd2" required="required">
				</td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" required="required">
				</td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="address" required="required">
				</td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="tel" name="tel" required="required"
					pattern="\d{2,3}-\d{3,4}-\d{4}"
				
					placeholder="010-xxxx-xxxx"
					title="2,3자리-3,4자리-4자리"></td>
					<!-- 회색으로 기본(예시) 보여줌 -->
						<!-- 마우스 갖다대면 나오고, 저 패턴과
					일치하지 않을 경우 틀렸다고 알려줌 --> 
			</tr>
			<tr>
				<td><input type="submit" value="확인"></td>
				<td><input type="reset" value="취소"></td>
			</tr>


		</table>

	</form>
</body>
</html>