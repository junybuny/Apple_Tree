package com.join.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.Controller;
import com.controller.HttpUtil;
import com.join.service.joinService;
import com.login.service.loginService;
import com.member.vo.memberVo;

public class joinController implements Controller{
	
	// 여기부터 맨아래 } 하나 빼고 까지 복사
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
	
		
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		if (name.isEmpty() || id.isEmpty() || passwd.isEmpty()) {
			request.setAttribute("error", "모든 항목을 빠짐없이 입력해주시기 바랍니다!");
			HttpUtil.forward(request, response, "/memberJoin.jsp");
			return;
		}
		
		memberVo member = new memberVo();
		member.setMember_name(name);
		member.setMember_id(id);
		member.setMember_pw(passwd);

		// Service 객체의 메소드 호출
		// 똑같이 적기
		joinService service = joinService.getInstance();

		boolean result = service.memberJoin(member); 
		
		if (!result) { // 회원가입 실패
			request.setAttribute("error", "다시 시도해주세요.");
			HttpUtil.forward(request, response, "/join.jsp");
		} else { // 회원가입 성공
			request.setAttribute("error", "회원가입 성공 로그인해주세요");
			HttpUtil.forward(request, response, "/login.jsp");
		}
		
	}
	
	//여기
}
