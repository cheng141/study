package com.wisezone.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.wisezone.entity.User;
import com.wisezone.mapper.BaseMapper;
import com.wisezone.mapper.UserMapper;
import com.wisezone.service.UserService;
import com.wisezone.util.MyBatisUtil;
import com.wisezone.util.mybatis.Criterion;
import com.wisezone.util.mybatis.OptionEnum;
import com.wisezone.util.mybatis.SearchParameter;

public class UserServiceImpl extends BaseServiceImpl<User, Integer> implements UserService {

	@Override
	public Class<? extends BaseMapper> getBaseMapper() {

		return UserMapper.class;
	}

	@Override
	public User login(User user) {

		SqlSession session = MyBatisUtil.getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);

		// 实例化对象
		SearchParameter params = new SearchParameter();
		params.addParameter(new Criterion("userName", OptionEnum.eq, user.getUserName()));
		params.addParameter(new Criterion("userPwd", OptionEnum.eq, user.getUserPwd()));

		List<User> arr = mapper.search(params);
		session.close();

		return arr.size() > 0 ? arr.get(0) : null;
	}

}
