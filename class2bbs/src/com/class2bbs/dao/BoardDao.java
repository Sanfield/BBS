package com.class2bbs.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.class2bbs.bean.BoardBean;

public class BoardDao extends DbDao {
	/**
	 * 获得所有的1级板块
	 */
	public List<BoardBean> findBoard() {
		String sql = "SELECT boId, boName, boDate, boTime, boFlag "
				+ "FROM board WHERE boFlag='1'";
		ResultSet rs = query(sql);
		List<BoardBean> list = new ArrayList<BoardBean>();
		try {
			while (rs.next()) {
				list.add(boxData(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	private BoardBean boxData(ResultSet rs) throws SQLException {
		BoardBean board = new BoardBean();
		board.setBoId(rs.getString("boId"));
		board.setBoName(rs.getString("boName"));
		board.setBoDate(rs.getDate("boDate"));
		board.setBoTime(rs.getTime("boTime"));
		board.setBoFlag(rs.getString("boFlag"));
		return board;
	}
}
