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
		//���2�����ı��
		//��ѯ2�������
		//������ӱ��
		//��½���û�
		//ת��ҳ��
		req.getRequestDispatcher("/reply.jsp").forward(req, resp);
	}

}
