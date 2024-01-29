package och17;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//@WebFilter("/sub2/*")
public class LoginCheck extends HttpFilter implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest=(HttpServletRequest)request;
		HttpServletResponse httpServletResponse=(HttpServletResponse)response;
		//request와 response의 값을 바꿔서 doFilter로 씀
		
		//세션작업
		HttpSession session=httpServletRequest.getSession();
		System.out.println("logincheck do filter");
		//세션 오류시
		if(session==null||session.equals("")) {
			httpServletResponse.sendRedirect("../login.jsp");}
		String id=(String)session.getAttribute("id");
		//check.jsp에서 id를 session.setAttribute했기 때문에 가능. 이렇게 받아옴
		
		//id 가져오기 오류시
		if(id==null||id.equals("")) {
			httpServletResponse.sendRedirect("../login.jsp");}
		
		

		super.doFilter(request, response, chain);
		//check에서 설정한 대로, 아이디와 비밀번호 정상적으로 넣었을 시 winner.jsp로 이동. 
	}

}
