<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>logout</title>
</head>
<body>

	<%
		String id = (String) session.getAttribute("session_id");
		if (id != null)
		session.invalidate();
		pageContext.forward("first.jsp");
	%>

</body>
</html>