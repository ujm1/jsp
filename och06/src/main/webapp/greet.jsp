<%@page import="java.io.FileWriter"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.GregorianCalendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!private PrintWriter pw;
	String date; //클래스의 멤버변수라고 보면 될듯. 즉 아래의 메서드에서, 
	//다른 서블릿틀릿으로 분해되었다고 하더라도 쓸 수 있다(받아준다)

	public void jspInit() { //전의 init 부분. 이것도 마찬가지로 단 한번. 시작시. 
		//서블릿.jsp.jspPage 인터페이스에 정의된 메서드다.

		GregorianCalendar gc = new GregorianCalendar();
		date = String.format("%TF %TT", gc, gc);
		System.out.println("date->" + date);
		String fileName = "c:/log/" + date.replaceAll(":", "") + ".txt";
									//앞선 예제와 달리 직접 파일 이름을 정해줄건데,
									//제목(날짜)에 : 가 있으면 파일생성이 안되기 때문에 그걸 없앰
		try {
			pw = new PrintWriter(new FileWriter(fileName, true));

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("jspInit 헐");
		}
	}%>

	<% /*  doget 부분 */
	String name = request.getParameter("name");
	String msg = name + "님 반가워";
	out.println(msg + "<p>현재시간:" + date);
	pw.println(msg + "\r\n현재시간:" + date + "\r\n");
	%>


	<%!public void jspDestory() { //이 또한..
		System.out.println("jspDestroy start...");
		pw.flush();
		if (pw != null) {
			pw.close();
		}
	}%>
</body>
</html>