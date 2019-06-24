package com.wisezone.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wisezone.entity.User;
import com.wisezone.service.UserService;
import com.wisezone.service.impl.UserServiceImpl;
import com.wisezone.vo.JsonVO;

//登录servlet
@WebServlet("/login")
public class LoginServlet extends BaseServlet {

	private UserService userService = new UserServiceImpl();

	// 显示登录界面
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/ftl/login.ftl").forward(req, resp);
	}

	// 登录验证
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 取参数
		// 取参数
		User user = new User();
		user.setUserName(req.getParameter("userName"));
		user.setUserPwd(req.getParameter("userPwd"));
		// 验证
		User dbUser = this.userService.login(user);

		// 3、判断
		if (dbUser == null) {
			JsonVO vo = new JsonVO();
			vo.setCode(500);
			vo.setMessage("用户名或者密码错误!");
			super.printJson(vo, resp);

		} else {
			// 成功的，但账号被锁定的
			if (dbUser.getState() == 0) {
				JsonVO vo = new JsonVO();
				vo.setCode(403);
				vo.setMessage("该账户已被锁定，请联系管理员进行解锁!");
				super.printJson(vo, resp);
			} else {
				// 存储登录信息
				super.setUserSession(dbUser, req);

				// 重定向到首页(只能是相对路径) ，如果使用ajax提交，重定向没有任何意思义的 resp.sendRedirect("index");

				JsonVO vo = new JsonVO();
				vo.setCode(0);
				vo.setMessage("index");
				super.printJson(vo, resp);

			}

		}

	}

}
