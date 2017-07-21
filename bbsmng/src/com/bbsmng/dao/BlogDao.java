package com.bbsmng.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bbsmng.bean.BlogBean;

public class BlogDao extends DbDao {
	
	public boolean deleteBlogs(String[] blids){
		if(blids==null||blids.length==0){
			return false;
		}
		String[] sql=new String[blids.length];
		for(int i=0;i<blids.length;i++){
			sql[i]="update blog set blDelete='1' where blid='"+blids[i]+"'";
		}
		if(update(sql)==1){
			
			return true;
		}
		return false;
	}

	public int insertBlog(BlogBean blog) {
		String sql = "INSERT INTO blog (blTitle, blText, blDate, blTime, uname, cbId, blDelete) "
				+ "VALUES (?,?,?,?,?,?,?) ";
		Object[] param = { blog.getBlTitle(), blog.getBlText(),
				blog.getBlDate(), blog.getBlTime(), blog.getUname(),
				blog.getCbId(), blog.getBlDelete() };
		return update(sql,param);
	}

	public BlogBean findById(String id) {
		String sql = "SELECT blId, blTitle, blText, blDate, blTime, b.uname, cbId, blDelete ,uphoto,uregDate "
				+ "FROM blog b LEFT JOIN users u ON b.uname=u.uname "
				+ "WHERE blDelete='0' AND blId=" + id;
		ResultSet rs = query(sql);
		try {
			if (rs.next()) {
				BlogBean blog = boxBlog(rs);
				blog.setPhoto(rs.getString("uphoto"));
				blog.setRegDate(rs.getDate("uregDate"));
				return blog;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return null;
	}

	public int findCountByCbid(String cbid) {
		String sql = "select count(blId) from blog where cbId='" + cbid
				+ "' and blDelete='0'";
		ResultSet rs = query(sql);
		try {
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return 0;
	}

	public List<BlogBean> findByCbid(String cbid) {
		String sql = "SELECT b.blId, blTitle, blText, blDate, blTime, uname, cbId, blDelete ,cnt "
				+ "FROM blog b "
				+ "LEFT JOIN (SELECT blId,COUNT(rbid) cnt FROM replyblog WHERE rbDelete='0' GROUP BY blId) t1 "
				+ "ON b.blId=t1.blId "
				+ "WHERE cbId=? AND blDelete='0' ORDER BY blDate DESC,blTime DESC";
		ResultSet rs = query(sql, new Object[] { cbid });
		List<BlogBean> list = new ArrayList<BlogBean>();
		try {
			while (rs.next()) {
				BlogBean blog = boxBlog(rs);
				blog.setReplyCount(rs.getInt("cnt"));
				list.add(blog);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	public List<BlogBean> findByCbid(String cbid, int pageSize, int pageNow) {
		String sql = "SELECT b.blId, blTitle, blText, blDate, blTime, uname, cbId, blDelete ,cnt "
				+ "FROM blog b "
				+ "LEFT JOIN (SELECT blId,COUNT(rbid) cnt FROM replyblog WHERE rbDelete='0' GROUP BY blId) t1 "
				+ "ON b.blId=t1.blId "
				+ "WHERE cbId=? AND blDelete='0' ORDER BY blDate DESC,blTime DESC "
				+ "LIMIT " + ((pageNow - 1) * pageSize) + "," + pageSize;
		ResultSet rs = query(sql, new Object[] { cbid });
		List<BlogBean> list = new ArrayList<BlogBean>();
		try {
			while (rs.next()) {
				BlogBean blog = boxBlog(rs);
				blog.setReplyCount(rs.getInt("cnt"));
				list.add(blog);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	private BlogBean boxBlog(ResultSet rs) throws SQLException {
		BlogBean blog = new BlogBean();
		blog.setBlId(rs.getInt("blId"));
		blog.setBlTitle(rs.getString("blTitle"));
		blog.setBlText(rs.getString("blText"));
		blog.setBlDate(rs.getDate("blDate"));
		blog.setCbId(rs.getString("cbId"));
		blog.setBlTime(rs.getTime("blTime"));
		blog.setUname(rs.getString("uname"));
		blog.setBlDelete(rs.getString("blDelete"));
		return blog;
	}
}
