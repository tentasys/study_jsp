<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 에러 페이지의 정의 : 페이지 지시어 사용 -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		response.setStatus(200);
		String msg = exception.getMessage();
	%>
	
	<h1>error message : <%=msg %></h1>
</body>
</html>