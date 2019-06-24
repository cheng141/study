package com.wisezone.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//注销
@WebServlet(urlPatterns="/logout")
public class LogOutServlet extends HttpServlet { 
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 //将session无效化
		HttpSession session=req.getSession();
		session.invalidate();
		//重定向到登录界面
		String webName=req.getContextPath();  //项目名称
		resp.sendRedirect(webName+"/login");
	}
}
