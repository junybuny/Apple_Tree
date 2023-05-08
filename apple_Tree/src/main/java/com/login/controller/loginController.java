package com.login.controller;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.Controller;
import com.controller.HttpUtil;
import com.login.service.*;
import com.member.vo.*;
import com.dao.*;

public class loginController implements Controller {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		// 똑같이 적기
		request.setCharacterEncoding("UTF-8");
		// jsp의 form태그안의 값을 받아옴
		String id = request.getParameter("id"); 
		String passwd = request.getParameter("passwd");
		
		// 똑같이 적기
		HttpSession session = request.getSession();
		
		
		if (id.isEmpty() || passwd.isEmpty()) {
			request.setAttribute("error", "아이디와 패스워드를 빠짐없이 입력해주시기 바랍니다!");
			HttpUtil.forward(request, response, "/login.jsp");
			return;
		}

		Member member = new Member();
		member.setMember_id(id);
		member.setMember_pw(passwd);

		// Service 객체의 메소드 호출
		// 똑같이 적기
		loginService service = loginService.getInstance();
		
		// 다를 수도 있음  Y/N
		boolean result = service.memberLogin(member);
		
		
		// Y인지 아닌지 여기서 확인될거야
		
		  if(result) { //인증된 사용자
		         session.setAttribute("session_id", id);
		         HttpUtil.forward(request, response, "/main.jsp");
		      }else{ //인증되지 않은 사용자(로그인실패)
		         request.setAttribute("error", "아이디와 패스워드가 잘못 입력되었습니다.");
		         HttpUtil.forward(request, response, "/login.jsp");
		      }
	}

}
