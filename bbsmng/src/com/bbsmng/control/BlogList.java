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
		//����2�������
		String cbName = new ChildBoardDao().findNameById(cbid);
		//��2���������� ( �ظ��� ) ��ҳ
		BlogDao bd = new BlogDao();
		String pn = req.getParameter("pn");
		int pageNow = pn==null?1:Integer.valueOf(pn);
		String psize = this.getServletConfig().getInitParameter("psize");
		int pageSize=psize==null?10:Integer.valueOf(psize);
		int rowCount = bd.findCountByCbid(cbid);
		int pageCount = rowCount%pageSize==0?rowCount/pageSize:rowCount/pageSize+1;
		
		List<BlogBean> list = bd.findByCbid(cbid,pageSize,pageNow);
		
		//��ҳ����Ҫ�����ݷ�req��
		req.setAttribute("cbid", cbid);
		req.setAttribute("cbName", cbName);
		req.setAttribute("blogs", list);
		req.setAttribute("pageNow", pageNow);
		
		//ת��ҳ��
		req.getRequestDispatcher("/list.jsp").forward(req, resp);
	}

}
