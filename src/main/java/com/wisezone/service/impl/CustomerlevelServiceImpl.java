package com.wisezone.service.impl;

import com.wisezone.entity.Customerlevel;
import com.wisezone.mapper.BaseMapper;
import com.wisezone.mapper.CustomerlevelMapper;
import com.wisezone.service.CustomerlevelService;

public class CustomerlevelServiceImpl extends BaseServiceImpl<Customerlevel, Integer> implements CustomerlevelService {

	@Override
	public Class<? extends BaseMapper> getBaseMapper() {	 
		return CustomerlevelMapper.class;
	}

}
