package com.bbsmng.control;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.bbsmng.bean.BlogBean;
import com.bbsmng.dao.BlogDao;

/**
 * Servlet implementation class BlogControl
 */
@WebServlet("/blog")
public class BlogControl extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String method= req.getParameter("method");
		if(method==null||method.equals(""))
			return;
		try{
			Method m=this.getClass().getDeclaredMethod(method, HttpServletRequest.class,HttpServletResponse.class);
			m.invoke(this, req,resp);
		}catch(Exception e){
			e.printStackTrace();
		}

	}
	@SuppressWarnings("unused")
	private void blogList(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String cbid = req.getParameter("cbid");

		cbid = cbid != null && cbid.length() > 0 ? cbid.equals("-1") ? null
				: cbid : null;

		// 查2级板块的帖子 ( 回复数 ) 分页
		BlogDao bd = new BlogDao();
		String pn = req.getParameter("pn");
		int pageNow = pn == null ? 1 : Integer.valueOf(pn);
		String psize = this.getServletConfig().getInitParameter("psize");
		int pageSize = psize == null ? 10 : Integer.valueOf(psize);
		int rowCount = bd.findCountByCbid(cbid);
		int pageCount = rowCount % pageSize == 0 ? rowCount / pageSize
				: rowCount / pageSize + 1;

		List<BlogBean> list = bd.findByCbid(cbid, pageSize, pageNow);

		// 把页面需要的数据放req域
		req.setAttribute("blogs", list);
		req.setAttribute("pageNow", pageNow);
		req.setAttribute("cbid", cbid);

		// 转发页面
		req.getRequestDispatcher("/blog.jsp").forward(req, resp);
	}
	
	@SuppressWarnings("unused")
	private void delete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String[] blids = req.getParameterValues("blids");
		if(blids==null|| blids.length==0){
			return;
		}
		if(new BlogDao().deleteBlogs(blids)){
			resp.sendRedirect("blog?method=blogList");
		}
	}

	@SuppressWarnings("unused")
	private void a(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<BlogBean> list = new BlogDao().findByCbid("17", 10, 1);
		System.out.println(list.size());
		System.out.println(list);
		JSONArray json = JSONArray.fromObject(list);
		System.out.println(json.toString());
	}

}
