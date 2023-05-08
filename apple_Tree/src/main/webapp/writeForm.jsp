<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Apple Tree Board Write Form</title>
</head>
<body>
<div class="wrapper">

<jsp:include page="./navibar.jsp"/>	

	<main>
		<div style="width:90%">
			<form action="boardWrite.do" method="post">
			
					제목<br/>
					<input type="text" name="title"><br/><br/>
					내용<br/>
					<input type="file" value="파일첨부"><br/>
					<textarea rows="10" cols="50" name="content">여기에 쓰세요!</textarea><br>
					
					<input type="submit" value="등록">
					<input type="reset" value="취소">
			</form>
		</div>
	</main>
	
</div>

</body>
</html>