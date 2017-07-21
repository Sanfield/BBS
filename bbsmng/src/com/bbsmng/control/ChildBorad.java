
package com.bbsmng.control;

import java.io.IOException;
import java.util.List;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbsmng.bean.BoardBean;
import com.bbsmng.bean.ChildBoardBean;
import com.bbsmng.dao.BoardDao;
import com.bbsmng.dao.ChildBoardDao;

@WebServlet("/ChildBorad")
public class ChildBorad extends HttpServlet {

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
		req.getRequestDispatcher("/child.jsp").forward(req, resp);
	}

}
