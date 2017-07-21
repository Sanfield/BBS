
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
		//�����ҳ��Ҫ������ ��
			//1.1�����
		List<BoardBean> boards = new BoardDao().findBoard();
			//2.2�����  ������ /������)
		List<ChildBoardBean> childBoards = new  ChildBoardDao().findChildBoard();
		//�����ݷŵ�request��
		req.setAttribute("boards", boards);
		req.setAttribute("childBoards", childBoards);
		//ת������ҳ ��
		req.getRequestDispatcher("/child.jsp").forward(req, resp);
	}

}
