<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
			String msg = (String)request.getAttribute("error");
			if(msg != null){
			%>
				<script type="text/javascript">
				var msg = <%=msg%>;
					alert(msg);
				</script>
			<%
			}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Apple Tree Join</title>
</head>
<body>


<a href = "first.jsp"><h2>🍎Apple Tree</h2></a>

<div style="text-align: center;">

	<h2>회원가입</h2>
	

	<form action="join.do" method="post">
	
			<p>이름 : <input type="text" name="name"></p>
			<p>ID : <input type="text" name="id"></p>
			<p>비밀번호 : <input type="password" name="passwd"></p>
			<p>비밀번호 확인 : <input type="password" name="passwd"></p>
			
			
			<input type="submit" value="회원가입">
	</form>

</div>
</body>
</html>