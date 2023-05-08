package com.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.dao.DBcon;
import com.member.vo.Member;

public class loginDao {

	// 싱글톤 객체 생성 ==> Singleton
	private static loginDao dao = new loginDao();

	private loginDao() {
	}

	public static loginDao getInstance() {
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

	public boolean memberLogin(Member member) throws SQLException {
		
		// 똑같이 만들어 =========
		Connection con = DBcon.getConnection();
		System.out.print("여기"+con);
		
		PreparedStatement ps;
		ResultSet rs;
		String sql;
		// ========여기까지 =====
		
		boolean loginResult = false;
		

		sql = "select member_id from member where member_id = ? and member_pw = ?";
		ps = con.prepareStatement(sql);
		ps.setString(1, member.getMember_id());
		ps.setString(2, member.getMember_pw());
		rs = ps.executeQuery();
		
		System.out.print("여기"+rs);

		// 트루면 if문을 실행하고 리턴
		// 펄스면 if문 실행 안하고 리턴
		if (rs.next()) {
			loginResult = true;
		}

		// Y 아니면 N
		return loginResult;

	}

}
