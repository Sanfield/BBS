package com.bbsmng.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import com.bbsmng.bean.UserBean;
import com.bbsmng.common.CodePass;
import com.bbsmng.dao.UserDao;
@WebServlet("/user")
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
		String uname = req.getParameter("uname");
		String upass = req.getParameter("upass");
		
		UserBean user = new UserDao().findByName(uname);
		
		req.setAttribute("uname", uname);
		req.setAttribute("upass", upass);
		
		if(user==null){
			req.setAttribute("msg", "用户名错误");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
			return;
		}
		
		if(!CodePass.encodePass(upass).equals(user.getUpass())){
			req.setAttribute("msg", "密码错误");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
			return;
		}
		
		if(!user.getUadmin().equals("1")){
			req.setAttribute("msg", "必须是管理员");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
			return;
		}
		
		HttpSession session = req.getSession();
		session.setAttribute("uname", uname);
		
		resp.sendRedirect(req.getContextPath()+"/main.jsp");
		
	}

	private void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.getSession().invalidate();
		resp.sendRedirect(req.getContextPath()+"/login.jsp");
	}
	private void getUsers(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		List<UserBean> users = new UserDao().getUsers();
		req.setAttribute("users", users);
	//	System.out.println(users);
		req.getRequestDispatcher("/user.jsp").forward(req, resp);
	}

}

