package com.wisezone.web.role;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.wisezone.entity.Role;
import com.wisezone.service.BaseService;
import com.wisezone.service.RoleService;
import com.wisezone.service.impl.RoleServiceImpl;
import com.wisezone.util.mybatis.SearchParameter;
import com.wisezone.web.BaseServlet;
import com.wisezone.web.NoramlPageServlet;

//角色查询
@WebServlet(urlPatterns = "/role/search")
public class SearchServlet extends NoramlPageServlet {

	// 业务逻辑类
	private RoleService roleService = new RoleServiceImpl();

	@Override
	public String viewName() {		 
		return "/WEB-INF/ftl/role/list.ftl";
	}

	@Override
	public BaseService getBaseServiceImpl() {		 
		return roleService;
	}

	 

}
