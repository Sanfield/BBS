package com.bbsmng.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bbsmng.bean.ReplyBlogBean;

public class ReplyBlogDao extends DbDao {
	public List<ReplyBlogBean> findByBlid(String id) {
		String sql = "SELECT rbId, rbText, rbDate, rbTime, rb.uname, blId, rbDelete ,uphoto,uregDate "
				+ "FROM replyblog rb LEFT JOIN users u ON rb.uname=u.uname "
				+ "WHERE rbDelete='0' AND blId=" + id;
		ResultSet rs = query(sql);
		List<ReplyBlogBean> list = new ArrayList<ReplyBlogBean>();
		try {
			while(rs.next()){
				ReplyBlogBean rblog = boxReplyBlog(rs);
				rblog.setPhoto(rs.getString("uphoto"));
				rblog.setRegDate(rs.getDate("uregDate"));
				list.add(rblog);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close();
		}
		return list;
	}
	
	private ReplyBlogBean boxReplyBlog(ResultSet rs) throws SQLException{
		ReplyBlogBean rblog = new ReplyBlogBean();
		rblog.setRbId(rs.getInt("rbId"));
		rblog.setRbText(rs.getString("rbText"));
		rblog.setRbDate(rs.getDate("rbDate"));
		rblog.setRbTime(rs.getTime("rbTime"));
		rblog.setUname(rs.getString("uname"));
		rblog.setBlId(rs.getInt("blId"));
		rblog.setRbDelete(rs.getString("rbDelete"));
		return rblog;
	}
}
