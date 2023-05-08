package com.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.board.vo.Board;
import com.dao.DBcon;
import com.member.vo.Member;

public class boardDao {
	
	//똑같이 해도됨(필요도 없는데 왜있는지 모르겠다)
	// 싱글톤 객체 생성 ==> Singleton
	private static boardDao dao = new boardDao();

	private boardDao() {
	}

	public static boardDao getInstance() {
		return dao;
	}

	// select 동작 실행 후...
	public void close(Connection conn, PreparedStatement ps, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception ex) {
				System.out.println("오류 발생 : " + ex);
			}
		}
		close(conn, ps);
	}

	// insert, update, delete 동작 실행 후..
	public void close(Connection conn, PreparedStatement ps) {
		if (ps != null) {
			try {
				ps.close();
			} catch (Exception ex) {
				System.out.println("오류 발생 : " + ex);
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception ex) {
				System.out.println("오류 발생 : " + ex);
			}
		}
	}

	public boolean boardWrite(Board board) throws SQLException {
		
		// 똑같이 만들어 =========
		Connection con = DBcon.getConnection();
		System.out.print("여기"+con);
		
		PreparedStatement ps;
		int rs;
		String sql;
		// ========여기까지 =====
		
		boolean boardResult = false;
		

		sql = "insert into board (title, writer, content) values (?,?,?)";
		ps = con.prepareStatement(sql);
		ps.setString(1, board.getTitle());
		ps.setString(2, board.getWriter());
		ps.setString(3, board.getContent());
		rs = ps.executeUpdate();
		
		System.out.print("여기"+rs);

		// 트루면 if문을 실행하고 리턴
		// 펄스면 if문 실행 안하고 리턴
		if (rs != 0) {
			boardResult = true;
		}

		// Y 아니면 N
		return boardResult;

	}

}
