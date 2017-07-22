package com.class2bbs.control;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.class2bbs.bean.BlogBean;
import com.class2bbs.dao.BlogDao;
import com.class2bbs.dao.ChildBoardDao;
@WebServlet("/post.do")
public class PostControl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//���2������š�
		String cbid = req.getParameter("cbid");
		//��ѯ2���������
		String cbName = new ChildBoardDao().findNameById(cbid);
		//��½���û�
		
		req.setAttribute("cbid", cbid);
		req.setAttribute("cbName", cbName);
		
		//ת��ҳ��
		req.getRequestDispatcher("/post.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		BlogBean blog = new BlogBean();
		blog.setBlTitle(req.getParameter("title"));
		blog.setBlText(req.getParameter("content"));
		blog.setCbId(req.getParameter("cbid"));
		blog.setUname((String)req.getSession().getAttribute("uname"));
		blog.setBlDate(new Date(new java.util.Date().getTime()));
		blog.setBlTime(new Time(new java.util.Date().getTime()));
		blog.setBlDelete("0");
		
		if(new BlogDao().insertBlog(blog)==1){
			resp.sendRedirect(req.getContextPath()+"/list?cbid="+blog.getCbId());
		}
	}

}
