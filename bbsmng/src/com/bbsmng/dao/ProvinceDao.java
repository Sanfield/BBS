package com.bbsmng.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bbsmng.bean.ProvinceBean;

public class ProvinceDao extends DbDao {
	public List<ProvinceBean> findProvince(){
		String sql="SELECT pid, pname FROM province ";
		ResultSet rs = query(sql);
		List<ProvinceBean> list = new ArrayList<ProvinceBean>();
		list.add(new ProvinceBean("-1", "--«Î—°‘Ò °∑›--"));
		try {
			while(rs.next()){
				ProvinceBean p = new ProvinceBean();
				p.setPid(rs.getString("pid"));
				p.setPname(rs.getString("pname"));
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
