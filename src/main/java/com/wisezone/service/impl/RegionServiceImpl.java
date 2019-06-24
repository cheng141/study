package com.wisezone.service.impl;

import com.wisezone.entity.Region;
import com.wisezone.mapper.BaseMapper;
import com.wisezone.mapper.RegionMapper;
import com.wisezone.service.RegionService;

public class RegionServiceImpl extends BaseServiceImpl<Region, Integer> implements RegionService {
 
	
	@Override
	public Class<? extends BaseMapper> getBaseMapper() {
		 
		return RegionMapper.class;
	}

}
