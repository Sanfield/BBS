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
		//获得首页需要的数据 。
			//1.1级板块
		List<BoardBean> boards = new BoardDao().findBoard();
			//2.2级板块  （数量 /最新帖)
		List<ChildBoardBean> childBoards = new  ChildBoardDao().findChildBoard();
		//把数据放到request域
		req.setAttribute("boards", boards);
		req.setAttribute("childBoards", childBoards);
		//转发到首页 。
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}

}
