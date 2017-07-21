package com.bbsmng.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bbsmng.bean.BlogBean;
import com.bbsmng.bean.ChildBoardBean;

public class ChildBoardDao extends DbDao {
	
	public String findNameById(String cbid){
		String sql="SELECT cboName from childboard where cbId='"+cbid+"' and cboFlag='1'";
		ResultSet rs = query(sql);
		try {
			if(rs.next()){
				return rs.getString("cboName");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close();
		}
		return null;
	}
	
	public List<ChildBoardBean> findChildBoard() {
		String sql = "SELECT cb.cbId, cboName, boaId, cboDate, cboTime, cboFlag ,cnt,blId, blTitle, blText, blDate, blTime, uname, blDelete "
				+ "FROM childboard cb "
				+ "LEFT JOIN (SELECT cbId,COUNT(blId) cnt FROM blog WHERE blDelete='0' GROUP BY cbId) t1 "
				+ "ON cb.cbId=t1.cbId "
				+ "LEFT JOIN (SELECT blId, blTitle, blText, blDate, blTime, uname, cbId, blDelete FROM ( "
				+ "SELECT blId, blTitle, blText, blDate, blTime, uname, cbId, blDelete "
				+ "FROM blog WHERE blDelete='0' ORDER BY blDate DESC,blTime DESC "
				+ ") t2 GROUP BY t2.cbId) t3 ON cb.cbId=t3.cbId "
				+ "WHERE cboFlag='1'";
		ResultSet rs = query(sql);
		List<ChildBoardBean> list = new ArrayList<ChildBoardBean>();
		try {
			while (rs.next()) {
				ChildBoardBean child = boxChildBoard(rs);
				child.setCnt(rs.getInt("cnt"));
				BlogBean newBlog = new BlogBean();
				newBlog.setBlId(rs.getInt("blId"));
				newBlog.setBlTitle(rs.getString("blTitle"));
				newBlog.setBlText(rs.getString("blText"));
				newBlog.setBlDate(rs.getDate("blDate"));
				newBlog.setCbId(rs.getString("cbId"));
				newBlog.setBlTime(rs.getTime("blTime"));
				newBlog.setUname(rs.getString("uname"));
				newBlog.setBlDelete(rs.getString("blDelete"));
				child.setBlog(newBlog);
				list.add(child);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	public List<ChildBoardBean> findChildBoard(String pid) {
		String sql = "SELECT cb.cbId, cboName, boaId ,cboDate, cboTime, cboFlag  "
				+ "FROM childboard cb ";
				if(pid!=null&&pid.length()>0){
					sql+= "WHERE boaId='"+pid+"'";
				}
		ResultSet rs = query(sql);
		List<ChildBoardBean> list = new ArrayList<ChildBoardBean>();
		try {
			while (rs.next()) {
				ChildBoardBean child = boxChildBoard(rs);
				list.add(child);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	private ChildBoardBean boxChildBoard(ResultSet rs) throws SQLException {
		ChildBoardBean child = new ChildBoardBean();
		child.setCbId(rs.getString("cbId"));
		child.setCboName(rs.getString("cboName"));
		child.setBoaId(rs.getString("boaId"));
	//	child.setCboDate(rs.getDate("cboDate"));
	//	child.setCboTime(rs.getTime("cboTime"));
	//	child.setCboFlag(rs.getString("cboFlag"));
		return child;
	}
}
