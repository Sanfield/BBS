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
@WebServlet("/doReg")//@WebServletע��ָ����ǰ����servlet����ָ��urlpattern
public class RegisterControl extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// �ͻ��˷��͵��������˵Ĳ����������ַ����� �ֽ�
		// ������������������ϴ� ��  (jsp smart upload.jar)   (commons-file-upload)
		
		//jsmartupload
		//1.�������������
		SmartUpload su = new SmartUpload();
		//2.��ʼ�����Ķ���
		su.initialize(this.getServletConfig(), req, resp);
		//3.�����ϴ��ļ��Ĵ�С�����͡���
		su.setMaxFileSize(1048576l);
		su.setAllowedFilesList("jpg,gif,jpeg,png,bmp");
		String f="";
		try {
			//4.�ϴ�.
			su.upload();
			//5.���ϴ����ļ�����
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
		user.setUsex(request.getParameter("gender").equals("1")?"Ů":"��");
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
