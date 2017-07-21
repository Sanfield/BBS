package com.bbsmng.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbsmng.bean.BlogBean;
import com.bbsmng.dao.BlogDao;
import com.bbsmng.dao.ChildBoardDao;

public class BlogList extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String cbid = req.getParameter("cbid");
		//查找2及板块名
		String cbName = new ChildBoardDao().findNameById(cbid);
		//查2级板块的帖子 ( 回复数 ) 分页
		BlogDao bd = new BlogDao();
		String pn = req.getParameter("pn");
		int pageNow = pn==null?1:Integer.valueOf(pn);
		String psize = this.getServletConfig().getInitParameter("psize");
		int pageSize=psize==null?10:Integer.valueOf(psize);
		int rowCount = bd.findCountByCbid(cbid);
		int pageCount = rowCount%pageSize==0?rowCount/pageSize:rowCount/pageSize+1;
		
		List<BlogBean> list = bd.findByCbid(cbid,pageSize,pageNow);
		
		//把页面需要的数据放req域
		req.setAttribute("cbid", cbid);
		req.setAttribute("cbName", cbName);
		req.setAttribute("blogs", list);
		req.setAttribute("pageNow", pageNow);
		
		//转发页面
		req.getRequestDispatcher("/list.jsp").forward(req, resp);
	}

}
