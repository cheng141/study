package com.wisezone.service.impl;

import com.wisezone.entity.Customer;
import com.wisezone.mapper.BaseMapper;
import com.wisezone.mapper.CustomerMapper;
import com.wisezone.service.CustomerService;

public class CustomerServiceImpl  extends BaseServiceImpl<Customer, Integer> implements CustomerService{

	@Override
	public Class<? extends BaseMapper> getBaseMapper() {		 
		return CustomerMapper.class;
	}

	 
}
