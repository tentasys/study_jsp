package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginCon")
public class loginCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String mId = request.getParameter("mID");
		String mPw = request.getParameter("mPw");
		
		out.print("mID : "+mId);
		out.print("mPw : "+mId);
		
		//쿠키는 클라이언트에 저장 -> 클라이언트 요청에 의해 들어온 것이므로 request에서 가져온다
		Cookie[] cookies = request.getCookies();
		Cookie cookie = null;
		
		for(Cookie c : cookies)
		{
			System.out.println("c.getName()"+c.getName()+", c.getValue()"+c.getValue());
			
			if(c.getName().equals("memberID")) {
				cookie = c;
			}
		}
		if(cookie == null)
		{
			System.out.println("cookie is null");
			cookie = new Cookie("memberID", mId);
		}
		
		response.addCookie(cookie);
		cookie.setMaxAge(60*60);	//쿠키의 만료 시간을 1시간으로 설정 
		
		response.sendRedirect("loginOk.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
