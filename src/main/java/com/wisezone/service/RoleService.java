package com.wisezone.service;

import java.util.List;

import com.wisezone.entity.Role;
import com.wisezone.util.mybatis.SearchParameter;

public interface RoleService  extends BaseService<Role,Integer>{

	String searchPaging(SearchParameter params);
 
}
