package com.wisezone.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wisezone.entity.Role;
import com.wisezone.mapper.BaseMapper;
import com.wisezone.mapper.RoleMapper;
import com.wisezone.service.RoleService;
import com.wisezone.util.MyBatisUtil;
import com.wisezone.util.mybatis.SearchParameter;

public class RoleServiceImpl extends BaseServiceImpl<Role,Integer> implements RoleService {

	 
	
	@Override
	public Class<? extends BaseMapper> getBaseMapper() {		 
		return RoleMapper.class;
	}

	 

	 
	  

}
