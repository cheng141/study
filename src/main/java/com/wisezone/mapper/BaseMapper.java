package com.wisezone.mapper;

import java.io.Serializable;
import java.util.List;
 
import com.wisezone.util.mybatis.SearchParameter;

/**
 * 父类
 * @author Administrator
 *
 * @param <T> 实体类型
 * @param <PK> 主键的类型
 */
public interface BaseMapper<T, PK extends Serializable> {
	  
	//新增
    int insert(T record);
   
    //多条件查询
    List<T> search(SearchParameter searchParameter);
    
	//根据主键查询  selectByPrimaryKey   改为findOne
    T findOne(PK id);

     //选择性更新
    int updateByPrimaryKeySelective(T record);

    //全部列列新
    int updateByPrimaryKey(T record);
}
