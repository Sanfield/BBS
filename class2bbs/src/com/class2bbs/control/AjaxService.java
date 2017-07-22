package com.class2bbs.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.class2bbs.bean.CityBean;
import com.class2bbs.bean.ProvinceBean;
import com.class2bbs.bean.UserBean;
import com.class2bbs.dao.CityDao;
import com.class2bbs.dao.ProvinceDao;
import com.class2bbs.dao.UserDao;

public class AjaxService extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		String method = req.getParameter("method");
		if (method == null || method.equals("")) {
			return;
		}
		try {
			Method m = this.getClass().getDeclaredMethod(method,
					HttpServletRequest.class, HttpServletResponse.class);
			m.invoke(this, req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void getProv(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<ProvinceBean> list = new ProvinceDao().findProvince();
		PrintWriter out = resp.getWriter();
		JSONArray json = JSONArray.fromObject(list);
		out.print(json.toString());
		out.flush();
		out.close();
	}
	
	private void getCity(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String pid = req.getParameter("pid");
		List<CityBean> list = new CityDao().findCityByPid(pid);
		PrintWriter out = resp.getWriter();
		JSONArray json = JSONArray.fromObject(list);
		out.print(json.toString());
		out.flush();
		out.close();
	}
	
	private void checkUname(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String uname = req.getParameter("uname");
		UserBean user = new UserDao().findByName(uname);
		PrintWriter out = resp.getWriter();
		if(user!=null){
			out.print("true");
		}else{
			out.print("false");
		}
		out.flush();
		out.close();
	}

}
