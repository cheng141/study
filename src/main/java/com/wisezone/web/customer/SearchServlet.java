package com.wisezone.web.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wisezone.entity.Customerlevel;
import com.wisezone.service.BaseService;
import com.wisezone.service.CustomerService;
import com.wisezone.service.CustomerlevelService;
import com.wisezone.service.impl.CustomerServiceImpl;
import com.wisezone.service.impl.CustomerlevelServiceImpl;
import com.wisezone.util.mybatis.Criterion;
import com.wisezone.util.mybatis.OptionEnum;
import com.wisezone.util.mybatis.SearchParameter;
import com.wisezone.web.BaseServlet;
import com.wisezone.web.NoramlPageServlet;

@WebServlet(urlPatterns = "/customer/search")
public class SearchServlet extends BaseServlet {

	private CustomerService customerService = new CustomerServiceImpl();

	// 客户等级
	private CustomerlevelService levelService = new CustomerlevelServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 从数据库中查询数据
		SearchParameter params = new SearchParameter();
		// 只有查询state=1
		params.addParameter(new Criterion("state", OptionEnum.eq, 1));
		List<Customerlevel> arrLevel = this.levelService.search(params);

		// 转发数据
		req.setAttribute("arrLevel", arrLevel);

		req.getRequestDispatcher("/WEB-INF/ftl/customer/list.ftl").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 创建查询对象，步骤是规定的
		SearchParameter params = super.getRequestParams(req);		
		//自己取前台返回参数
		
		

		// 格式必须是 {total:多少笔， rows:集合 }
		String json = customerService.searchPaging(params);

		// 响应 输出 给前端 (规定写法)
		super.printJson(json, resp);

	}
}
