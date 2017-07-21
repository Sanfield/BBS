package com.bbsmng.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbsmng.bean.BlogBean;
import com.bbsmng.bean.ReplyBlogBean;
import com.bbsmng.dao.BlogDao;
import com.bbsmng.dao.ChildBoardDao;
import com.bbsmng.dao.ReplyBlogDao;
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
