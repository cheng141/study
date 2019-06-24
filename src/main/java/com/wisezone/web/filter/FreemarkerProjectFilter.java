package com.wisezone.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * 为每一个请求，动态的  得到该项目的名称
 * @author Administrator
 *
 */
@WebFilter(urlPatterns="/*")
public class FreemarkerProjectFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		 HttpServletRequest req=(HttpServletRequest) request;
		 //取得当前项目的名称
		 String webName=req.getServletContext().getContextPath();		
		 req.setAttribute("ctx", webName);
		 
		 //放行
		 chain.doFilter(req, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
