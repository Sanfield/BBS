package com.class2bbs.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.class2bbs.bean.BlogBean;
import com.class2bbs.bean.ReplyBlogBean;
import com.class2bbs.dao.BlogDao;
import com.class2bbs.dao.ChildBoardDao;
import com.class2bbs.dao.ReplyBlogDao;
@WebServlet("/detail")
public class DetailControl extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String cbid = req.getParameter("cbid");
		String blid = req.getParameter("blid");
		//����2������Ų�����
		String cbName = new ChildBoardDao().findNameById(cbid);
		//�������ӱ�Ų�������Ϣ
		BlogBean blog = new BlogDao().findById(blid);
		//�������ӱ�Ų�ظ���Ϣ
		List<ReplyBlogBean> list = new ReplyBlogDao().findByBlid(blid);
		
		//�ŵ�������
		req.setAttribute("cbid", cbid);
		req.setAttribute("cbName", cbName);
		req.setAttribute("blog", blog);
		req.setAttribute("rblogs", list);
		
		//ת��
		req.getRequestDispatcher("/detail.jsp").forward(req, resp);
	}

}
