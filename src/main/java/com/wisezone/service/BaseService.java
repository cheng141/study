package com.wisezone.service;

import java.io.Serializable;
import java.util.List;

import com.wisezone.mapper.BaseMapper;
import com.wisezone.util.mybatis.SearchParameter;

public interface BaseService<T , PK extends Serializable> {

	  //新增
    boolean insert(T record);
   
    //多条件查询
    List<T> search(SearchParameter searchParameter);
    
	//根据主键查询  selectByPrimaryKey   改为findOne
    T findOne(PK id);

     //选择性更新
    boolean updateByPrimaryKeySelective(T record);

    //全部列列新
    boolean updateByPrimaryKey(T record);
    
    /**
     * 到底是哪个类型(BaseMapper的子类)
     * @return
     */
    public Class<? extends BaseMapper>  getBaseMapper();
    
    
	/**
	 * 分页查询
	 * @param params
	 * @return
	 */
	public String searchPaging(SearchParameter params);
    

}
