<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Montserrat:100,300,400,500,700"/><link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css'><link rel="stylesheet" href="./style.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="wrapper">
 <sidebar>
	<div class="logo">
		<a href="main.jsp">🍎Apple Tree</a>
	</div>
    <div class="avatar">
      <div class="avatar__img">
        <img src="https://cdn4.iconfinder.com/data/icons/linecon/512/photo-50.png" alt="avatar">
      </div>
      <div class="avatar__name">손윤정</div>
    </div>
    <nav class="menu">
      <a class="menu__item" href="#">
        <i class="menu__icon fa fa-home"></i>
        <span class="menu__text">방명록</span>
      </a>
      <a class="menu__item" href="board.jsp">
        <i class="menu__icon fa fa-envelope"></i>
        <span class="menu__text">일기</span>
      </a>
      <a class="menu__item" href="#">
        <i class="menu__icon fa fa-list"></i>
        <span class="menu__text">독서리스트</span>
      </a>
      <a class="menu__item menu__item--active" href="./calender.jsp">
        <i class="menu__icon fa fa-calendar"></i>
        <span class="menu__text">일정</span>
      </a>
    </nav>
    <div class="copyright"><a href="logout.jsp">로그아웃</a></div>
</div>
</sidebar>
</body>
</html>