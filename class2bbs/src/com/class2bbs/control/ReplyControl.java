package com.class2bbs.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/reply.do")
public class ReplyControl extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//获得2级板块的编号
		//查询2级板块名
		//获得帖子编号
		//登陆的用户
		//转发页面
		req.getRequestDispatcher("/reply.jsp").forward(req, resp);
	}

}
