package com.wisezone.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wisezone.entity.User;
import com.wisezone.util.mybatis.SearchParameter;
import com.wisezone.vo.JsonVO;

//基础
public class BaseServlet extends HttpServlet {

	// 登录标识
	public static final String USER_SESSION_TOKEN = "currentUser";

	/**
	 * 登录操作
	 * 
	 * @param value
	 */
	public void setUserSession(Object value, HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.setAttribute(USER_SESSION_TOKEN, value);
	}

	/**
	 * 取得用户session，如果为null代表已经失败了[未登录。登录超时]
	 * 
	 * @param req
	 * @return
	 */
	public User getUserSession(HttpServletRequest req) {
		HttpSession session = req.getSession();
		// 存在
		if (session.getAttribute(USER_SESSION_TOKEN) != null) {
			return (User) session.getAttribute(USER_SESSION_TOKEN);
		}

		return null;
	}

	// 输出json
	protected void printJson(JSONObject json, HttpServletResponse resp) {
		PrintWriter out;
		try {
			out = resp.getWriter();
			out.println(json.toJSONString());
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 输出json
	 * 
	 * @param json
	 * @param resp
	 */
	protected void printJson(JSONArray json, HttpServletResponse resp) {
		PrintWriter out;
		try {
			out = resp.getWriter();
			out.println(json.toJSONString());
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// 输出json
	protected void printJson(String jsonStr, HttpServletResponse resp) {
		PrintWriter out;
		try {
			out = resp.getWriter();
			out.println(jsonStr);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// 输出json
	protected void printJson(JsonVO json, HttpServletResponse resp) {
		PrintWriter out;
		try {
			out = resp.getWriter();
			String str = JSONObject.toJSONString(json);

			out.println(str);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * 得到分页的参数
	 * 
	 * @param req
	 * @return
	 */
	protected SearchParameter getRequestParams(HttpServletRequest req) {
		// 创建查询对象，步骤是规定的
		SearchParameter params = new SearchParameter();
		// bootstrap-table传给你的参数，你自己要手动去取，分页取得分页参数 pageSize=10&pageNumber=1
		
		//为了防止程序员乱调
		if (StringUtils.isNotBlank(req.getParameter("pageSize"))) {
			
			int pageSize = Integer.parseInt(req.getParameter("pageSize")); // 每页显示几笔
			params.setSize(pageSize); // 每页显示几笔

			int pageNumber = Integer.parseInt(req.getParameter("pageNumber")); // 当前第几页
			params.setPage(pageNumber); // 当前第几页

		}
		return params;

	}

}
