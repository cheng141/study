package com.wisezone.service;

import com.wisezone.entity.User;

public interface UserService  extends BaseService<User, Integer>{

	/**
	 * 登录操作
	 * @param user
	 * @return
	 */
	public User login(User user);
}
