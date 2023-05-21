<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>CodePen - CSS Grid calendar</title>
  <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Montserrat:100,300,400,500,700"/><link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
  <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css'><link rel="stylesheet" href="./style.css">
  <link rel="stylesheet" href="css/mypage.css">
</head>
<body>
  <div class="wrapper" align="center">
    <main>
      <div id="frlst-container" class="frlst-container">
        <div class="app-header">
          <span>친구 목록</span>
        </div>
        <div class="frlst-body">
          <ul v-if="frlst.length>0">
            <li class="friend-list" v-for="(friend,index) in frlst">
              <div class="list-item-view">
                <div class="item">
                  <label :class="{ completed: todo.completed }">백소희</label>
                </div>
                <button @click="removeFriend(index)" class="btn btn-danger">삭제</button>
              </div>
            </li>
          </ul>
        </div>
        <div class="frlst-form">
          <input placeholder="아이디를 입력하세요." v-model="newFriend" @keyup.enter="addFriend" type="text" class="input-text" name="">
          <button @click="addFriend" class="btn btn-danger">추가</button>
        </div>
      </div>
    </main>

<sidebar>
  <div class="logo">🍎Apple Tree🍎
  </div>
  <div class="avatar">
    <div class="avatar__img">
      <img src="https://cdn4.iconfinder.com/data/icons/linecon/512/photo-50.png" alt="avatar">
    </div>
    <div class="avatar__name">손윤정</div>
  </div>
  <nav class="menu">
    <a class="menu__item " href="mainpage.jsp">
      <i class="menu__icon fa fa-home"></i>
      <span class="menu__text">방명록</span>
    </a>
    <a class="menu__item "href="messages.jsp">
      <i class="menu__icon fa fa-envelope"></i>
      <span class="menu__text">일기</span>
    </a>
    <a class="menu__item" href="#">
      <i class="menu__icon fa fa-list"></i>
      <span class="menu__text">독서리스트</span>
    </a>
    <a class="menu__item" href="calender.jsp">
      <i class="menu__icon fa fa-calendar"></i>
      <span class="menu__text">일정</span>
     </a>
     <a class="menu__item  menu__item--active" href="friend.jsp">
      <i class="menu__icon fa fa-friend"></i>
      <span class="menu__text">친구</span>
     </a>
    </nav>
  </sidebar>
</div>

</body>
</html>