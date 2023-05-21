package com.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.board.vo.boardVo;
import com.dao.DBcon;

	public class boardDao {
	    //싱글톤 객체 생성 ==> Singleton
	    private static boardDao dao = new boardDao();
	    private boardDao(){}
	    public static boardDao getInstance(){
	       return dao;
	    }

		public Connection connect() {
		   Connection con = null;
		   try {
		      InitialContext ic = new InitialContext();
		      // member 파일 경로인가?
		      DataSource ds = (DataSource)ic.lookup("java:comp/env/jdbc/univ");
		      con = ds.getConnection();
		      
		   }catch(Exception e) {
		      e.printStackTrace();
		   }
		   return con;
		}
		
		//select 동작 실행 후...
		public void close(Connection conn, PreparedStatement ps, ResultSet rs) {
		   if(rs != null) {
		      try {
		      rs.close();
		   } catch(Exception ex) {
		      System.out.println("오류 발생 : " + ex);
		       }
		    }
		    close(conn, ps);
		 }
		    
		    //insert, update, delete 동작 실행 후..
		public void close(Connection conn, PreparedStatement ps) {
		   if(ps != null) {
		      try {
		      ps.close();
		   } catch(Exception ex) {
		      System.out.println("오류 발생 : " + ex);
		   }
		}
		if(conn != null) {
		   try {
		      conn.close();
		   } catch(Exception ex) {
		      System.out.println("오류 발생 : " + ex);
		       }
		    }
		 }
		
		// 글 수정문인가
		public int insertBoard(boardVo b) {
		    Connection con = null;
		    PreparedStatement ps = null;
		    int a = 0;
		    
		    try {
		       con = this.connect();
		       String sql = "insert into board values(?, ?, ?, now(), 0, 0, 0, 0)";
		       ps = con.prepareStatement(sql);
				/*
				 * ps.setString(1, b.getName()); ps.setString(2, b.getSubject());
				 * ps.setString(3, b.getContent());
				 */
		       a = ps.executeUpdate();
		       
		    }catch (Exception e) {
		       e.printStackTrace();
		    }finally{
		       close(con, ps);
		    }
		    return a;
		 }
		 
		public ArrayList<boardVo> selectBoardList() {
		    Connection con = null;
		    PreparedStatement ps = null;
		    ResultSet rs = null; 
		    boardVo bb = null;
		    ArrayList<boardVo> list = null;
		    try {
		       con = this.connect();
		       String sql = "select * from board order by re_ref desc, re_seq asc";
		       ps = con.prepareStatement(sql);
		       rs = ps.executeQuery();
		       
		       if(rs.next()) {
		          list = new ArrayList<boardVo>();
		          do {
						/*
						 * bb = new boardVo(); bb.setTitle(rs.getInt("title"));
						 * bb.setContent(rs.getString("content"));
						 */
		             list.add(bb);
		          }while(rs.next());
		             
		       }
		       
		    } catch (SQLException e) {
		       // TODO Auto-generated catch block
		       e.printStackTrace();
		    } finally {
		       close(con, ps, rs);
		    }
		    return list;
		}
    
}
 