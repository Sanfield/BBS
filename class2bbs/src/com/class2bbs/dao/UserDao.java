package com.class2bbs.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.class2bbs.bean.UserBean;

public class UserDao extends DbDao {
	public int insertUser(UserBean user) {
		String sql = "INSERT INTO users (uname, upass, pid, cid, usex, uphoto, uregDate, uregTime, uadmin, uflag) "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?)";
		Object[] param = { user.getUname(), user.getUpass(), user.getPid(),
				user.getCid(), user.getUsex(), user.getUphoto(),
				user.getUregDate(), user.getUregTime(), user.getUadmin(),
				user.getUflag() };
		return update(sql, param);
	}

	public UserBean findByName(String uname) {
		String sql = "SELECT uname, upass, pid, cid, usex, uphoto, uregDate, uregTime, uadmin, uflag "
				+ "FROM users WHERE uname='" + uname + "'";
		ResultSet rs = query(sql);
		try {
			if (rs.next()) {
				return boxUser(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return null;
	}

	private UserBean boxUser(ResultSet rs) throws SQLException {
		UserBean user = new UserBean();
		user.setUname(rs.getString("uname"));
		user.setUpass(rs.getString("upass"));
		user.setPid(rs.getString("pid"));
		user.setCid(rs.getString("cid"));
		user.setUsex(rs.getString("usex"));
		user.setUphoto(rs.getString("uphoto"));
		user.setUregDate(rs.getDate("uregDate"));
		user.setUregTime(rs.getTime("uregTime"));
		user.setUadmin(rs.getString("uadmin"));
		user.setUflag(rs.getString("uflag"));
		return user;
	}
}
