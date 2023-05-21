package com.board.service;

import java.sql.SQLException;

import com.board.dao.boardDao;
import com.board.vo.boardVo;

public class boardService {

	private static boardService service = new boardService();

	private boardService() {
	}

	public static boardService getInstance() {
		return service;
	}

	public boardDao dao = boardDao.getInstance();

	public boolean boardWrite(boardVo board) throws SQLException {
		// TODO Auto-generated method stub
		return dao.boardWrite(board);
	}

}
