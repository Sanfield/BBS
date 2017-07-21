package com.bbsmng.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DbDao {
	private Connection con;
	private Statement sta;
	private PreparedStatement ps;
	private ResultSet rs;

	private void openCon() throws SQLException {
		try {
			Context c = new InitialContext();
			DataSource source = (DataSource) c
					.lookup("java:comp/env/jdbc/test");
			con = source.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public ResultSet query(String sql) {
		try {
			openCon();
			sta = con.createStatement();
			rs = sta.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public ResultSet query(String sql, Object[] param) {
		try {
			openCon();
			ps = con.prepareStatement(sql);
			if (param != null && param.length > 0) {
				for (int i = 0; i < param.length; i++) {
					ps.setObject(i + 1, param[i]);
				}
			}
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public int update(String sql) {
		try {
			openCon();
			sta = con.createStatement();
			return sta.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			close();
		}
	}
	public int update(String[] sql){
		try{
			openCon();
			con.setAutoCommit(false);//手动管理连接对象的自动提交
			sta=con.createStatement();
			for(int i=0;i<sql.length;i++){
				sta.executeUpdate(sql[i]);
				
			}
			con.commit();//没错提交
		}catch(SQLException e){
			try{
				con.rollback();//出错回滚
			}catch(SQLException el){
				el.printStackTrace();
				
			}
			e.printStackTrace();
			return -1;
		}finally{
			close();
		}
		return 1;
	}
	public int update(String sql, Object[] params) {
		try {
			openCon();
			ps = con.prepareStatement(sql);
			if (params != null && params.length > 0) {
				for (int i = 0; i < params.length; i++) {
					ps.setObject(i + 1, params[i]);
				}
			}
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			close();
		}
	}

	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (sta != null) {
				sta.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
