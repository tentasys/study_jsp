<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="errorPage.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!
		String adminId;
		String adminPw;
		
		String imgDir;
		String testServerIP;
		String realServerIP;
		
		String str;
	%>
	
	<!-- config 객체  -->
	<%
		adminId = config.getInitParameter("adminId");
		adminPw = config.getInitParameter("adminPw");
	%>
	
	<p>adminId : <%=adminId %></p>
	<p>adminPw : <%=adminPw %></p>
	
	<!-- application 객체 -->
	<%
	imgDir = application.getInitParameter("imgDir");
	testServerIP = application.getInitParameter("testServerIP");
	realServerIP = application.getInitParameter("realServerIP");
	%>
	
	<p>imgDir : <%=imgDir %></p>
	<p>testServerIP : <%=testServerIP %></p>
	<p>realServerIP : <%=realServerIP %></p>
	
	
	<%
		application.setAttribute("connectedIP", "111.22.33.44");
		application.setAttribute("connectedUser", "kang");
	%>
	
	<!-- out 객체 -->
	<%
		out.print("<h1>Hello Java World!</h1>");
		out.print("<h2>Hello JSP World!</h2>");
		out.print("<h3>Hello Servlet World!</h3>");
	%>
	
	<!-- exception 객체 -->
	<!-- 여기서 NullpointExcetpion이 발생한다 -> errorPage로 이동 -->
	<%
		out.print(str.toString());
	%>
</body>
</html>