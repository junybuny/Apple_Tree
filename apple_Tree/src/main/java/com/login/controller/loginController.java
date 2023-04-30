package com.login.controller;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.vo.*;
import com.controller.Controller;
import com.controller.HttpUtil;
import com.login.service.*;
import com.dao.*;


public class loginController implements Controller{
	@SuppressWarnings("null")
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		 String driver = "org.mariadb.jdbc.Driver";
		    Connection con = null;
		    PreparedStatement ps;
		    ResultSet rs;
		    String sql;
		
		try {
            Class.forName(driver);
            con = DriverManager.getConnection(
                    "jdbc:mariadb://127.0.0.1:3306/apple_tree",
                    "root",
                    "1234");
            
            if( con != null ) {
                System.out.println("DB 접속 성공");
            }
            
        } catch (ClassNotFoundException e) { 
            System.out.println("드라이버 로드 실패");
        } catch (SQLException e) {
            System.out.println("DB 접속 실패");
            e.printStackTrace();
        }
		
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		HttpSession session = request.getSession();

		if (id.isEmpty() || passwd.isEmpty()) {
			request.setAttribute("error", "아이디와 패스워드를 빠짐없이 입력해주시기 바랍니다!");
			HttpUtil.forward(request, response, "/login.jsp");
			return;
		}


		sql = "select member_id from member where member_id = ? and member_pw = ?";
		ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ps.setString(2, passwd);
		rs = ps.executeQuery();
		
		if (rs.next()) { // 인증된 사용자
			session.setAttribute("session_id", id);
			HttpUtil.forward(request, response, "/main.jsp");
		} else { // 인증되지 않은 사용자(로그인실패)
			request.setAttribute("error", "아이디와 패스워드가 잘못 입력되었습니다.");
			HttpUtil.forward(request, response, "/login.jsp");
		}
	}

}
