package com.class2bbs.control;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.class2bbs.bean.UserBean;
import com.class2bbs.common.CodePass;
import com.class2bbs.dao.UserDao;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
@WebServlet("/doReg")//@WebServlet注解指定当前类是servlet，且指定urlpattern
public class RegisterControl extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 客户端发送到服务器端的参数，不是字符串。 字节
		// 借助第三方组件，简化上传 ，  (jsp smart upload.jar)   (commons-file-upload)
		
		//jsmartupload
		//1.创建核心类对象
		SmartUpload su = new SmartUpload();
		//2.初始化核心对象
		su.initialize(this.getServletConfig(), req, resp);
		//3.限制上传文件的大小、类型、等
		su.setMaxFileSize(1048576l);
		su.setAllowedFilesList("jpg,gif,jpeg,png,bmp");
		String f="";
		try {
			//4.上传.
			su.upload();
			//5.把上传的文件保存
			f = su.getFiles().getFile(0).getFileName();
			su.save("/upload/");
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}
		
		Request request = su.getRequest();
		
		UserBean user = new UserBean();
		user.setUname(request.getParameter("uName"));
		user.setUpass(CodePass.encodePass(request.getParameter("uPass")));
		user.setPid(request.getParameter("prov"));
		user.setCid(request.getParameter("city"));
		user.setUsex(request.getParameter("gender").equals("1")?"女":"男");
		if(f.equals("")){
			user.setUphoto(request.getParameter("head"));
		}else{
			user.setUphoto("upload/"+f);
		}
		user.setUregDate(new Date(new java.util.Date().getTime()));
		user.setUregTime(new Time(new java.util.Date().getTime()));
		user.setUadmin("0");
		user.setUflag("0");
		System.out.println(user);
		
		if(new UserDao().insertUser(user)==1){
			HttpSession session = req.getSession();
			session.setAttribute("uname", user.getUname());
			resp.sendRedirect(req.getContextPath()+"/index");
		}
	}

}
