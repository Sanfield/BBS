package com.class2bbs.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.class2bbs.bean.CityBean;

public class CityDao extends DbDao {
	public List<CityBean> findCityByPid(String pid){
		String sql="SELECT cid, cname, father FROM city WHERE father='"+pid+"'";
		ResultSet rs = query(sql);
		List<CityBean> list = new ArrayList<CityBean>();
		list.add(new CityBean("-1", "--«Î—°‘Ò≥« –--",""));
		try {
			while(rs.next()){
				CityBean p = new CityBean();
				p.setCid(rs.getString("cid"));
				p.setCname(rs.getString("cname"));
				p.setFather(rs.getString("father"));
				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close();
		}
		return list;
	}
}
