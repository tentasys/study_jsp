<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 로그인할 때 쿠키가 있는지 없는지부터 확인해야 함  -->
	<%
		Cookie[] cookies = request.getCookies();
		System.out.println("cookies : " + cookies);
		
		if(cookies != null){
			for(Cookie c : cookies){
				if(c.getName().equals("memberID"))
					response.sendRedirect("loginOk.jsp");
			}
		}
	%>
	<form action="loginCon" method="post">
		ID : <input type="text" name="mID"><br>
		PW : <input type="password" name="mPw"><br>
		<input type="submit" name="login"><br>
	</form>
</body>
</html>