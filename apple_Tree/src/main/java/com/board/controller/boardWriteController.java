package com.board.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.service.boardService;
import com.board.vo.Board;
import com.controller.Controller;
import com.controller.HttpUtil;

public class boardWriteController implements Controller {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {


		// 똑같이 적기
		HttpSession session = request.getSession();
		// 똑같이 적기
		request.setCharacterEncoding("UTF-8");
		// jsp의 form태그안의 값을 받아옴
		String title = request.getParameter("title"); 
		String content = request.getParameter("content");
		String writer = (String)session.getAttribute("session_id");
		
		
		
		if (title.isEmpty() || content.isEmpty()) {
			request.setAttribute("error", "제목과 내용을 빠짐없이 입력해주세요!");
			HttpUtil.forward(request, response, "/writeForm.jsp");
			return;
		}

		Board board = new Board();
		board.setTitle(title);
		board.setContent(content);
		board.setWriter(writer);

		// Service 객체의 메소드 호출
		// 똑같이 적기
		boardService service = boardService.getInstance();
		
		// 다를 수도 있음  Y/N
		boolean result = service.boardWrite(board);
		
		
		// Y인지 아닌지 여기서 확인될거야
		
		  if(result) { 
		         HttpUtil.forward(request, response, "/board.jsp");
		      }else{ //인증되지 않은 사용자(로그인실패)
		         request.setAttribute("error", "게시글 작성에 실패했습니다..");
		         HttpUtil.forward(request, response, "/writeForm.jsp");
		      }
	}

}