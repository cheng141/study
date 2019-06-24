package com.wisezone.web.filter;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wisezone.entity.User;
import com.wisezone.web.BaseServlet;

/**
 * 验证是否登录
 * @author Administrator
 *
 */
@WebFilter(urlPatterns="/*")
public class LoginFilter implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
	 
	}
	 
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		 
		HttpServletRequest  req=(HttpServletRequest) request;
		HttpServletResponse resp=(HttpServletResponse) response;
		
	     String webName=req.getContextPath();  //项目名称
		
		//如果请求的 xxxx/login 放行
		String url=req.getRequestURI();
	  
	 
		 
		
		//直接放行,给特权 ,  放行assets静态资源文件夹 
		if(url.endsWith("/login")   ||  url.startsWith(webName+"/assets/")   ) {
			chain.doFilter(req, resp);
			return;
		}
		
		//取得session		
		 HttpSession session=req.getSession(); 
		 
		 //没登录  
		 if(session.getAttribute( BaseServlet.USER_SESSION_TOKEN)==null) {
			 //拦下来，重定向到登录界面
			 
			 resp.sendRedirect(webName+"/login");  
			 
		 }else {
			//登录过，放行
			 chain.doFilter(req, resp);
		 }  
	}

	 
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}


}
