package com.bbsmng.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.bbsmng.bean.BoardBean;
import com.bbsmng.bean.ChildBoardBean;
import com.bbsmng.bean.CityBean;
import com.bbsmng.bean.ProvinceBean;
import com.bbsmng.bean.UserBean;
import com.bbsmng.dao.BoardDao;
import com.bbsmng.dao.ChildBoardDao;
import com.bbsmng.dao.CityDao;
import com.bbsmng.dao.ProvinceDao;
import com.bbsmng.dao.UserDao;
@WebServlet("/ajax")
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
					HttpServletRequest.class, HttpServletResponse.class);//获取当前类，获取当前类的方法
			m.invoke(this, req, resp);//执行
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void getBoard(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//List<ProvinceBean> list = new ProvinceDao().findProvince();
		List<BoardBean> list=new BoardDao().findBoard();
		list.add(0,new BoardBean("-1","请选择"));
		PrintWriter out = resp.getWriter();
		JSONArray json = JSONArray.fromObject(list);
		out.print(json.toString());
		out.flush();
		out.close();
	}
	
	private void getChild(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String pid = req.getParameter("pid");
		//List<CityBean> list = new CityDao().findCityByPid(pid);
		List<ChildBoardBean> list= new ChildBoardDao().findChildBoard(pid);
		list.add(0,new ChildBoardBean("-1", "请选择二级板块"));
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
	private void insertBoard(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String uname = req.getParameter("boname");
		System.out.println(uname);
		BoardDao bd= new BoardDao();
		Integer id= bd.findMaxId()+1;
		BoardBean bb= new BoardBean();
		bb.setBoId(id+"");
		bb.setBoName(uname);
		bb.setBoDate(new Date(System.currentTimeMillis()));
		bb.setBoTime(new Time(System.currentTimeMillis()));
		bb.setBoFlag("1");
		PrintWriter out= resp.getWriter();
		if(bd.insertBoart(bb)==1){
			out.print("ok");
		}else{
			out.print("false");
		}
		out.flush();
		out.close();
	}

}
