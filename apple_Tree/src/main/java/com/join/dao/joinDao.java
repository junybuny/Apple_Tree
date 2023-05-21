package com.join.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dao.DBcon;
import com.member.vo.memberVo;

public class joinDao {

	// 싱글톤 객체 생성 ==> Singleton
	private static joinDao dao = new joinDao();

	private joinDao() {
	}

	public static joinDao getInstance() {
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

	public boolean memberJoin(memberVo member) throws SQLException {

		// 똑같이 만들어 =========
		Connection con = DBcon.getConnection();
		System.out.print("여기" + con);

		PreparedStatement ps;
		int rs;
		String sql;
		// ========여기까지 =====

		boolean joinResult = false;

		sql = "insert into member (member_name,member_id,member_pw) values (?,?,?)";
		ps = con.prepareStatement(sql);
		ps.setString(1, member.getMember_name());
		ps.setString(2, member.getMember_id());
		ps.setString(3, member.getMember_pw());
		try {
			rs = ps.executeUpdate();
		} catch (Exception e) {
			rs = 0;
		}

		System.out.print("여기" + rs);

		// 트루면 if문을 실행하고 리턴
		// 펄스면 if문 실행 안하고 리턴
		if (rs == 1) {
			joinResult = true;
		}

		// Y 아니면 N
		return joinResult;

	}

}
