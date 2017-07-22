package com.class2bbs.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.class2bbs.bean.BoardBean;
import com.class2bbs.bean.ChildBoardBean;
import com.class2bbs.dao.BoardDao;
import com.class2bbs.dao.ChildBoardDao;

public class Index extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//�����ҳ��Ҫ������ ��
			//1.1�����
		List<BoardBean> boards = new BoardDao().findBoard();
			//2.2�����  ������ /������)
		List<ChildBoardBean> childBoards = new  ChildBoardDao().findChildBoard();
		//�����ݷŵ�request��
		req.setAttribute("boards", boards);
		req.setAttribute("childBoards", childBoards);
		//ת������ҳ ��
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}

}
