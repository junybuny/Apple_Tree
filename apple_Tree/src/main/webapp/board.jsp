<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Apple Tree Board</title>
</head>
<body>
	<div class="wrapper">
		
		<jsp:include page="./navibar.jsp" />
		<main>
		<div style="height:30px">
			<div style="float:left; height:100%">
				<span style="font-size: 25px; font-weight: bold">오늘의 일기</span>
			</div>
			<div style="float:right; height:100%">
				<input type="button" value="+" onClick="location.href='writeForm.jsp'"/>
			</div>
		</div>
		<hr>
			
		</main>
	</div>
</body>
</html>