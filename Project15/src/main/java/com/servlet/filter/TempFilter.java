package com.servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class TempFilter implements Filter{

	@Override
	public void destroy() {
		System.out.println(" -- filter destroy() --");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		System.out.println(" -- filter doFilter() -- ");
		
		//request filter
		req.setCharacterEncoding("UTF-8");
		
		//dofilter 이전은 request 
		chain.doFilter(req, res);	//
		
		//dofilter 이후는 response 
		
		//filter를 만들기만 한다고 사용할 수 있는 것은 아님 -> web.xml에 내가 만든 필터를 등록해야 한다.
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println(" -- filter init() --");
		
	}
	

}
