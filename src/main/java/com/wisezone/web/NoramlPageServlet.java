package com.wisezone.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wisezone.service.BaseService;
import com.wisezone.util.mybatis.SearchParameter;

public abstract class NoramlPageServlet extends BaseServlet {

	// 显示页面
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher(this.viewName()).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 创建查询对象，步骤是规定的
		SearchParameter params = super.getRequestParams(req);

		// 格式必须是 {total:多少笔， rows:集合 }
		String json = this.getBaseServiceImpl().searchPaging(params);

		// 响应 输出 给前端 (规定写法)
		super.printJson(json, resp);
	}

	// 子类必须告诉我的页而什么
	public abstract String viewName();
	
	//子类必须告诉父类子类实现是什么
	public abstract BaseService getBaseServiceImpl();
}
