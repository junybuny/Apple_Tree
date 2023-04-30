package com.login.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.Controller;
import com.controller.HttpUtil;

public class joinController implements Controller{
	@SuppressWarnings("null")
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		
		 String driver = "org.mariadb.jdbc.Driver";
		    Connection con = null;
		    PreparedStatement ps;
		    int rs;
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
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		HttpSession session = request.getSession();

		
		sql = "insert into member values (?,?,?,'abc@gmail.com','경기도 서울시','010-1111-1111')";
		ps = con.prepareStatement(sql);
		ps.setString(1, name);
		ps.setString(2, id);
		ps.setString(3, passwd);
		try{
			rs = ps.executeUpdate();
		}catch(Exception e)
		{
			rs=0;
		}
		
		
		if (rs == 0) { // 회원가입 실패
			session.setAttribute("error", "다시 시도해주세요.");
			HttpUtil.forward(request, response, "/memberJoin.jsp");
		} else { // 회원가입 성공
			request.setAttribute("session_id", id);
			HttpUtil.forward(request, response, "/login.jsp");
		}
		
	}
}
