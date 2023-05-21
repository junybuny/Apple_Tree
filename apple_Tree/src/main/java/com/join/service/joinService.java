package com.join.service;

import java.sql.SQLException;

import com.join.dao.joinDao;
import com.member.vo.memberVo;

public class joinService {

	private static joinService service = new joinService();

	private joinService() {
	}

	public static joinService getInstance() {
		return service;
	}

	public joinDao dao = joinDao.getInstance();

	public boolean memberJoin(memberVo member) throws SQLException {

		// Y아니면 N
		return dao.memberJoin(member);
	}

}
