<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 기존 세션 여부 판단  -->
	<%
		if(session.getAttribute("memberId") != null)
			response.sendRedirect("loginOk.jsp");
	%>
	<form action="loginCon" method="post">
		ID : <input type="text" name="mID"><br>
		PW : <input type="password" name="mPw"><br>
		<input type="submit" name="login"><br>
	</form>
</body>
</html>