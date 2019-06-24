package com.wisezone.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;

@WebFilter(urlPatterns="/*", initParams= {
		@WebInitParam(name="encode",value="UTF-8")
})
public class EncodingFilter implements Filter {
	
	private String encoding="UTF-8";
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
        if(filterConfig.getInitParameter("encode")!=null) {
        	encoding=filterConfig.getInitParameter("encode").trim();
        }
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		  request.setCharacterEncoding(this.encoding);
		  response.setCharacterEncoding(this.encoding);
		  response.setContentType("text/html;charset="+this.encoding);
 
		
		  //放行
		chain.doFilter(request, response);		

	}

	@Override
	public void destroy() {
		

	}

}
