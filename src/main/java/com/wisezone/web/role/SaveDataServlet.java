package com.wisezone.web.role;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.wisezone.entity.Role;
import com.wisezone.service.RoleService;
import com.wisezone.service.impl.RoleServiceImpl;

//保存角色信息
@WebServlet(urlPatterns = "/role/save")
public class SaveDataServlet extends HttpServlet {

	private RoleService roleService = new RoleServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		// 1、接收参数 roleName=test&roleCode=aaaa&state=1&roleId=0
		Role role = new Role();
		role.setRoleName(req.getParameter("roleName"));
		role.setRoleCode(req.getParameter("roleCode"));
		role.setState(Integer.parseInt(req.getParameter("state")));

		// 2、主键
		int roleId = Integer.parseInt(req.getParameter("roleId"));
		role.setRoleId(roleId);

		//3、定义json
		JSONObject json = new JSONObject();
		// 4、调用 新增方法
		if (roleId == 0) {
			boolean result = this.roleService.insert(role);
			json.put("code", result ? 0 : 500);
			json.put("message", result ? "新增数据成功" : "新增数据失败");

		} else {
			// 修改方法
			boolean result = this.roleService.updateByPrimaryKey(role);
			json.put("code", result ? 0 : 500);
			json.put("message", result ? "保存数据成功" : "修改保存数据失败");
		}

		// json输出到客户端
		// 5、响应 输出 给前端 (规定写法)
		PrintWriter out = resp.getWriter();
		out.println(json.toJSONString());
		out.flush();
		out.close(); 
	}
}
