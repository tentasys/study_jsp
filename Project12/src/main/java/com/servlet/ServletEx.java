package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletEx extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String adminId = getServletConfig().getInitParameter("adminId");
		String adminPw = getServletConfig().getInitParameter("adminPw");
		
		PrintWriter out = response.getWriter();
		out.print("<p>adminId : "+ adminId+ "</p>");
		out.print("<p>adminPw : "+ adminPw+ "</p>");
		
		String imgDir = getServletContext().getInitParameter("imgDir");
		String testServerIP = getServletContext().getInitParameter("testServerIP");
		String realServerIP = getServletContext().getInitParameter("realServerIP");

		out.print("<p>imgDir : "+ imgDir+ "</p>");
		out.print("<p>testServerIP : "+ testServerIP+ "</p>");
		out.print("<p>realServerIP : "+ realServerIP+ "</p>");
		
		getServletContext().setAttribute("connectedIP", "111.22.33.44");
		getServletContext().setAttribute("connectedUser", "kang");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
