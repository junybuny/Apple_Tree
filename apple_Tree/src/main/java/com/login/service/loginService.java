package com.login.service;

import java.sql.SQLException;

import com.login.dao.loginDao;
import com.member.vo.memberVo;

public class loginService {

	private static loginService service = new loginService();

	private loginService() {
	}

	public static loginService getInstance() {
		return service;
	}

	public loginDao dao = loginDao.getInstance();

	public boolean memberLogin(memberVo member) throws SQLException {

		// Y아니면 N
		return dao.memberLogin(member);
	}

}
