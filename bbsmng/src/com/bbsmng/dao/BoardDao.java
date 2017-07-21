package com.bbsmng.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bbsmng.bean.BoardBean;

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
	//	System.out.println(list);
		return list;
	}
	public Integer findMaxId(){
		String sql= "SELECT MAX(boId) FROM board";
		ResultSet rs= query(sql);
		try{
			if(rs.next()){
				return rs.getInt(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close();
		}
		return -1;
	}
	public Integer insertBoart(BoardBean board){
		String sql="insert into board(boId,boName,boDate,boTime,boFlag) values(?,?,?,?,?)";
		Object[] param={board.getBoId(),board.getBoName(),board.getBoDate(),board.getBoTime(),board.getBoFlag()};
		return update(sql,param);
	}
	private BoardBean boxData(ResultSet rs) throws SQLException {
		BoardBean board = new BoardBean();
		board.setBoId(rs.getString("boId"));
		board.setBoName(rs.getString("boName"));
	//	board.setBoDate(rs.getDate("boDate"));
	//	board.setBoTime(rs.getTime("boTime"));
	//	board.setBoFlag(rs.getString("boFlag"));
		return board;
	}
}
