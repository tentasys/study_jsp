package com.servlet;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletEx
 */
@WebServlet("/SE")
public class ServletEx extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//servlet 실행 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(" -- doGet() -- ");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println(" -- postConstruct() -- ");
	}
	
	//servlet 생성
	@Override
	public void init() throws ServletException{
		System.out.println(" -- init() -- ");
	}
	
	//servlet 종료
	@Override
	public void destroy() {
		System.out.println(" -- destroy() -- ");
	}
	
	@PreDestroy
	public void preDestroy() {
		System.out.println(" -- preDestroy() -- ");
	}
}
