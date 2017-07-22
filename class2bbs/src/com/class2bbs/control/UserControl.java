package com.class2bbs.control;

import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.Date;
import java.sql.Time;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.class2bbs.bean.UserBean;
import com.class2bbs.common.CodePass;
import com.class2bbs.dao.UserDao;

public class UserControl extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String method = req.getParameter("method");
		if (method == null || method.equals("")) {
			return;
		}
		try {
			Method m = this.getClass().getDeclaredMethod(method,
					HttpServletRequest.class, HttpServletResponse.class);
			m.invoke(this, req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uname = req.getParameter("uName");
		String upass = req.getParameter("uPass");
		
		UserBean user = new UserDao().findByName(uname);
		
		req.setAttribute("uname", uname);
		req.setAttribute("upass", upass);
		
		if(user==null){
			req.setAttribute("msg", "”√ªß√˚¥ÌŒÛ");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
			return;
		}
		
		if(!CodePass.encodePass(upass).equals(user.getUpass())){
			req.setAttribute("msg", "√‹¬Î¥ÌŒÛ");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
			return;
		}
		
		if("1".equals(user.getUflag())){
			req.setAttribute("msg", "’À∫≈±ª∆¡±Œ");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
			return;
		}
		
		HttpSession session = req.getSession();
		session.setAttribute("uname", uname);
		
		resp.sendRedirect(req.getContextPath()+"/index");
		
	}

	private void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.getSession().invalidate();
		resp.sendRedirect(req.getContextPath()+"/index");
	}

}

