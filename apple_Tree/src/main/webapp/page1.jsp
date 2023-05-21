<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>CodePen - Internal Video Platform UI</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="./css/mainpage.css">

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script></head>

<script type="text/javascript">

var boardArray = new Array();

function Board(uContent) {
  this.content = uContent;
  this.writeDay = new Date();
}

Board.prototype.userLocalString=function() {
  return this.writeDay.getFullYear()+"."
  +(this.writeDay.getMonth()+1)+"."
  +this.writeDay.getDate()+"."
  +this.writeDay.getHours()+":"
  +this.writeDay.getSeconds();
}

function main() {
  var uContent=document.getElementById("uContent").value;

  var len = boardArray.length;

  boardArray[len] = new Board(uContent);

  print(len);

  clear();
}

funtion print(idx) {
  var tableNode = document.getElementById("bbsTable");
  var trNode=document.createElement("tr");
     
  trNode.appendChild(createTdNode((idx+1).toString()));
  trNode.appendChild(createTdNode(boardArray[idx].userName));
  trNode.appendChild(createTdNode(boardArray[idx].content));
  trNode.appendChild(createTdNode(boardArray[idx].userLocalString()));
      
  tableNode.appendChild(trNode);
   }
   
   function createTdNode(val)
   {
      var textNode = document.createTextNode(val);
      var tdNode = document.createElement("td");
      tdNode.appendChild(textNode);
      return tdNode;
   }
   
   function clear()
   {
	   	document.getElementById("uName").value="";
	   	document.getElementById("uContent").value="";
	   	document.getElementById("uName").focus();
	   
   }

</script>
</head>

<body>
<!-- partial:index.partial.html -->
 <link href="https://fonts.googleapis.com/css?family=DM+Sans:400,500,700&display=swap" rel="stylesheet">
 <div class="app-wrapper">
  <div class="left-area hide-on-mobile">
    <div class="app-header">Apple
      <span class="inner-text">Tree</span>
      <button class="close-menu">
        <svg width="24" height="24" fill="none" stroke="#51a380" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" class="feather feather-x">
          <defs />
          <path d="M18 6L6 18M6 6l12 12" />
        </svg>
      </button>
    </div>
    <div class="left-area-content">
      <div class="profile">
        <img src="data:image/jpeg;base64,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" alt="">
        <div class="profile-info">
          <span class="profile-name">볶음밥</span>
          <span class="country">Korea</span>
        </div>
      </div>
        <div class="page-link-list">
        <a href="page1.jsp" class="item-link active" id="pageLink">
          <svg class="link-icon" fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" class="feather feather-home" viewBox="0 0 24 24">
            <defs />
            <path d="M3 9l9-7 9 7v11a2 2 0 01-2 2H5a2 2 0 01-2-2z" />
            <path d="M9 22V12h6v10" /></svg>
          Home</a>
        <a href="page1.jsp" class="item-link" id="pageLink">
          <svg class="link-icon" xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-heart">
            <path d="M20.84 4.61a5.5 5.5 0 00-7.78 0L12 5.67l-1.06-1.06a5.5 5.5 0 00-7.78 7.78l1.06 1.06L12 21.23l7.78-7.78 1.06-1.06a5.5 5.5 0 000-7.78z" />
          </svg>
          Favourites</a>
        <a href="messages.jsp" class="item-link" id="pageLink">
          <svg class="link-icon" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-play">
            <path d="M5 3l14 9-14 9V3z" />
          </svg>
          My Daybook</a>
        <a href="calender.jsp" class="item-link" id="pageLink">
          <svg class="link-icon" xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-list">
            <path d="M8 6h13M8 12h13M8 18h13M3 6h.01M3 12h.01M3 18h.01" />
          </svg>
          Calendar</a>
        <a href="#" class="item-link" id="pageLink">
          <svg class="link-icon" xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-clock">
            <circle cx="12" cy="12" r="10" />
            <polyline points="12 6 12 12 16 14" /></svg>
          History</a>
      </div>
      <div class="list-header">
        <span class="">Private</span>
        <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-plus-circle">
          <circle cx="12" cy="12" r="10" />
          <line x1="12" y1="8" x2="12" y2="16" />
          <line x1="8" y1="12" x2="16" y2="12" /></svg>
      </div>
      <a href="#" class="item-link" id="pageLink">
        <svg class="link-icon" xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-lock">
          <rect x="3" y="11" width="18" height="11" rx="2" ry="2" />
          <path d="M7 11V7a5 5 0 0110 0v4" />
        </svg>
        Studio Records</a>
      <a href="#" class="item-link" id="pageLink">
        <svg class="link-icon" xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-lock">
          <rect x="3" y="11" width="18" height="11" rx="2" ry="2" />
          <path d="M7 11V7a5 5 0 0110 0v4" />
        </svg>
        Personal</a>
      <div class="list-header">
        <span class="">Public</span>
        <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-plus-circle">
          <circle cx="12" cy="12" r="10" />
          <line x1="12" y1="8" x2="12" y2="16" />
          <line x1="8" y1="12" x2="16" y2="12" /></svg>
      </div>
      <a href="#" class="item-link" id="pageLink">
        <svg class="link-icon" xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-folder">
          <path d="M22 19a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h5l2 3h9a2 2 0 0 1 2 2z" /></svg>
        Vlogs</a>
      <a href="#" class="item-link" id="pageLink">
        <svg class="link-icon" xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-folder">
          <path d="M22 19a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h5l2 3h9a2 2 0 0 1 2 2z" /></svg>
        Dance</a>
    </div>
    <button class="btn-invite">Invite Team</button>
  </div>
  <div class="right-area">
    <div class="right-area-upper">
      <button class="menu-button">
        <svg width="24" height="24" fill="none" stroke="#51a380" stroke-linecap="round" stroke-linejoin="round" stroke-width="2">
          <defs />
          <path d="M3 12h18M3 6h18M3 18h18" />
        </svg>
      </button>
      <div class="search-part-wrapper">
        <input class="search-input" type="text" placeholder="Search videos...">
        <a class="menu-links" href="./member/login.jsp">Login</a>
        <a class="menu-links" href="./member/join.jsp">Join</a>
        <button class="more-button">
          <svg width="24" height="24" fill="none" stroke="#51a380" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" class="feather feather-more-vertical">
            <defs />
            <circle cx="12" cy="12" r="1" />
            <circle cx="12" cy="5" r="1" />
            <circle cx="12" cy="19" r="1" />
          </svg>
        </button>
        <ul class="more-menu-list hide">
          <li><a href="./member/login.jsp">Login</a></li>
          <li><a href="./member/Join.jsp">Join</a></li>
          <li> <button class="action-buttons btn-record">Record</button></li>
          <li><button class="action-buttons btn-upload">Upload</button></li>
        </ul>
      </div>
      <button class="btn-notification">
        <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="#232428" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-bell">
          <path d="M18 8A6 6 0 006 8c0 7-3 9-3 9h18s-3-2-3-9M13.73 21a2 2 0 01-3.46 0" />
        </svg>
        <span>3</span>
      </button>
      <div class="action-buttons-wrapper">
        <button class="action-buttons btn-record">Record</button>
        <button class="action-buttons btn-upload">Upload</button>
      </div>
    </div>
    <div class="page-right-content">
      <div class="content-line content-line-hero">
        <div class="line-header">
          <span class="header-text">New Uploads</span>
        </div>
        <div class="slider-wrapper owl-carousel owl-theme" id="owl-slider-1">
          <div class="item hero-img-wrapper img-1">
            <div class="upload-text-wrapper">
              <p class="upload-text-header"> </p>
              <p class="upload-text-info"> <span></span></p>
            </div>
            <img src="https://img.freepik.com/free-vector/isaac-newton-sitting-under-apple-tree_1308-96274.jpg?w=2000&t=st=1684598172~exp=1684598772~hmac=afac7578fb82aafaa0820146e5f33be77c5d488dac50a999802da9183a5b8dd6" alt="SlideShow">
          </div>
          <div class="item hero-img-wrapper img-2">
            <div class="upload-text-wrapper">
              <p class="upload-text-header"></p>
              <p class="upload-text-info"> <span></span></p>
            </div>
            <img src="https://img.freepik.com/free-vector/vector-seamless-apple-pattern-pastel-background_53876-110525.jpg?w=1800&t=st=1684600355~exp=1684600955~hmac=a8a34f3b71998d8b61d72776e8a9c9a017ad3f7a553376647b1940e3250d5238" alt="SlideShow">
          </div>
          <div class="item hero-img-wrapper img-3">
            <div class="upload-text-wrapper">
              <p class="upload-text-header"></p>
              <p class="upload-text-info"> <span></span></p>
            </div>
            <img src="https://img.freepik.com/free-vector/peach-background-vector-cute-desktop-wallpaper_53876-136871.jpg?w=1800&t=st=1684600385~exp=1684600985~hmac=801b73f57eeef7ffd32b18e8c338b9a27da3927dfd255f4f68630ccb19731630" alt="SlideShow">
          </div>
        </div>
      </div>
      <div class="content-line content-line-list">
        <div class="line-header">
          <span class="header-text">Tree</span>
        </div>
           <div class="wrapper">
    <main role="main" class="container">
      <center>
       <div class="center">
          <div class="leaf" id="leaf" href="#" data-toggle="modal" data-target="#memoModal"><img src="./img/leaf.png"></div>
          <div style="position: relative;">
            <div class="tree"><img src="./img/tree.png"></div>
            <div style="position: absoulte; top: 5px; left: 5px;">
            <div class="apple" id="apple" href="#" data-toggle="messageModal" data-target="#memoModal"><img src="./img/apple.png"></div>
            </div>
          </div>

        </div>
          <div class="popup" id="modal">
            <div class="title">방명록 작성</div>
            <div class="content">
              <table class="tbl">
                <tr>
                  <td>
                  <input type="text" id="uContent" placeholder="내용을 입력해주세요" value="">
                  </td>
              </tr>
             </table>
              </div>
            <div class="cmd">
              <input type="button" id="btnclose" class="button" value="닫기">
              <input type="button" id="btnsubmit" class="button" value="등록" onclick="main()">
            </div>
          </div>
          <div class="popupMessage" id="messageModal">
            <div class="title">작성된 방명록</div>
            <div class="content">
              <table clas="tbl" id="bbsTable">
                <tr>
                  <th>안녕 잘지내? 벌써 여름이다</th>
                </tr>
              </table>
            </div>
            <div class="cmd">
              <input type="button" id="btnclose2" class="button" value="닫기">
              <input type="button" id="btndel" class="button" value="삭제">
            </div>
          </div>
      </center>
        <bottom>
          <div align="left">
            <div class="schedulelist">
            <span>다가오는 일정</span>
            <span>오늘의 일정</span>
            </div>
            <div class="schedule">
              <span>5/10</span>
              <span>캡스톤 보고서 제출</span>
            </div>
            <div class="schedule">
              <span>5/10</span>
              <span>준 소희 모찌 보러오는 날</span>
            </div>
          </div>
          <div align="right">
            <div class="friendlist">
              <span>친구 목록</span>
              <span>다가오는 일정</span>
            </div>
              <div class="schedule">
                <span>준</span>
                <span>5/12<span>
                <span>인공지능소프트웨어 MT</span>
              </div>
              <div class="schedule">
                <span>소희</span>
                <span>5/17<span>
                <span>캡스톤 11주차 기능 구현</span>
              </div>
          </bottom>
    </div>
    </main>
<!-- partial -->
  <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js'></script><script  src="./js/script.js"></script>
<script>
      document.getElementById("leaf").onclick = function() {
        document.getElementById("modal").style.display="block";
    }
   
    document.getElementById("btnclose").onclick = function() {
        document.getElementById("modal").style.display="none";
    }  
    document.getElementById("apple").onclick = function() {
        document.getElementById("messageModal").style.display="block";
    }

    document.getElementById("btnclose2").onclick = function() {
        document.getElementById("messageModal").style.display="none";
    }   

    document.getElementById("btndel").onclick = function() {
        document.getElementById("apple").style.display="none";
        document.getElementById("messageModal").style.display="none";
    }   
</script>
</body>
</html>
