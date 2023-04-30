package com.controller;

import java.io.IOException;
import java.lang.ModuleLayer.Controller;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.login.controller.joinController;
import com.login.controller.loginController;


/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      try {
		doProcess(request, response);
	} catch (ServletException | IOException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      try {
		doProcess(request, response);
	} catch (ServletException | IOException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   
   protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
      // TODO Auto-generated method stub
      
      //1.요청파악
      String requestURI = request.getRequestURI(); // /Autumn/loginPro.do
      String contextPath = request.getContextPath();// /Autumn
      
      String command = requestURI.substring(contextPath.length()); // /loginPro.do
      loginController loginAction = null;
      joinController joinAction = null;
      
      //2.각 요청별로 연결될 비즈니스 로직 호출
      if(command.equals("/login.do")) {
    	  loginAction = new loginController();
    	  loginAction.execute(request, response);
      }
      if(command.equals("/join.do")) {
    	  joinAction = new joinController();
    	  joinAction.execute(request, response);
       }   
      
      //3.포워딩
   }

}