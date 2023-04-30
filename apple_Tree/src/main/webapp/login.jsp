<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Apple Tree Login</title>
</head>

<body>
	<%
		String msg = (String)request.getAttribute("error");
		if(msg == null)
			msg="";
	%>
<a href = "first.jsp"><h2>🍎Apple Tree</h2></a>
	
<div style="text-align: center;">
	
	<h2>로그인</h2>
	<p><%=msg%></p>
	
		<form action="login.do" method="post">
				<p>ID : <input type="text" name="id" /></p>
				<p>비밀번호 : <input type="password" name="passwd" /></p>
				
				<br/>
				<input type="submit" value="로그인" />
				<a href = "memberJoin.jsp">회원가입</a>
		</form>
		
</div>	

</body>
</html>