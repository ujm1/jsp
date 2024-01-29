package och17;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

//@WebFilter("/sub1/*") //이걸 써줘야 필터 쓸 수 있음. 이렇게 어노테이션으로 해도 되지만
//web.xml에서 filter, filter-mapping 설정해줘도 됨
public class SimpleFilter implements Filter {
	
	public void init(FilterConfig filterConfig) throws ServletException{
		Filter.super.init(filterConfig);
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Filter시작");
		chain.doFilter(request,response);
		System.out.println("Filter 끝");
	}

}
