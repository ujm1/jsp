<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	try {
			int num1 = Integer.parseInt(request.getParameter("num1"));
			int num2 = Integer.parseInt(request.getParameter("num2"));
			out.println(num1+"+"+num2+"="+(num1+num2)+"<p>");
			out.println(num1+"-"+num2+"="+(num1-num2)+"<p>");
			out.println(num1+"x"+num2+"="+(num1*num2)+"<p>");
			out.println(num1+"/"+num2+"="+(num1/num2)+"<p>");
		} catch (NumberFormatException nfe) {
			out.println("nfe error");
		}
		catch (ArithmeticException ae) {
			out.println("ae error");
		}catch (Exception e) {
			out.println(e.getMessage());
		}  
		
%>
</body>
</html>