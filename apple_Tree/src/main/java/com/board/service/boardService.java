package com.board.service;

import java.sql.SQLException;

import com.board.dao.boardDao;
import com.board.vo.Board;
import com.login.dao.loginDao;
import com.login.service.loginService;
import com.member.vo.Member;

public class boardService {

	private static boardService service = new boardService();

	private boardService() {
	}

	public static boardService getInstance() {
		return service;
	}

	public boardDao dao = boardDao.getInstance();

	public boolean boardWrite(Board board) throws SQLException {
		// TODO Auto-generated method stub
		return dao.boardWrite(board);
	}

}
