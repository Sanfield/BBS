package com.bbsmng.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bbsmng.bean.BlogBean;
import com.bbsmng.bean.UserBean;

public class UserDao extends DbDao {

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
	public List<UserBean> getUsers(){
	
		String sql="SELECT uname,usex,uadmin,p.pname,c.cname FROM users u LEFT JOIN  province p ON u.pid=p.pid "
				+"LEFT JOIN city c ON u.cid=c.cid";
		ResultSet rs = query(sql);
		List<UserBean> list = new ArrayList<UserBean>();
		try {
			while (rs.next()) {
				UserBean user = new UserBean();
				user.setUname(rs.getString("uname"));
				user.setUsex(rs.getString("usex"));
				user.setUadmin(rs.getString("uadmin"));
				user.setPname(rs.getString("pname"));
				user.setCname(rs.getString("cname"));
				list.add(user);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
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
