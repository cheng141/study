package com.wisezone.service.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;
import com.wisezone.entity.Role;
import com.wisezone.mapper.BaseMapper;
import com.wisezone.mapper.RoleMapper;
import com.wisezone.service.BaseService;
import com.wisezone.util.MyBatisUtil;
import com.wisezone.util.mybatis.SearchParameter;

/**
 * 基础业务逻辑实现公共类(子类必须实现接口的方法，除非子类也是一个抽象类)
 * 
 * @author Administrator
 *
 * @param <T>
 * @param <PK>
 */
public abstract class BaseServiceImpl<T, PK extends Serializable> implements BaseService<T, PK> {
	@Override
	public boolean insert(T record) {
		SqlSession session = MyBatisUtil.getSession();
		// 父类 a=new 子类();
		BaseMapper<T, PK> mapper = session.getMapper(getBaseMapper());
		boolean result = mapper.insert(record) > 0;
		session.commit();
		session.close();
		return result;
	}

	@Override
	public List<T> search(SearchParameter searchParameter) {
		SqlSession session = MyBatisUtil.getSession();
		// 父类 a=new 子类();
		BaseMapper<T, PK> mapper = session.getMapper(getBaseMapper());

		List<T> arr = mapper.search(searchParameter);

		session.close();

		return arr;
	}

	@Override
	public T findOne(PK id) {
		SqlSession session = MyBatisUtil.getSession();
		// 父类 a=new 子类();
		BaseMapper<T, PK> mapper = session.getMapper(getBaseMapper());

		T obj = mapper.findOne(id);

		session.close();

		return obj;
	}

	@Override
	public boolean updateByPrimaryKeySelective(T record) {
		SqlSession session = MyBatisUtil.getSession();
		// 父类 a=new 子类();
		BaseMapper<T, PK> mapper = session.getMapper(getBaseMapper());

		boolean result = mapper.updateByPrimaryKeySelective(record) > 0;
		session.commit();
		session.close();
		return result;
	}

	@Override
	public boolean updateByPrimaryKey(T record) {
		SqlSession session = MyBatisUtil.getSession();
		// 父类 a=new 子类();
		BaseMapper<T, PK> mapper = session.getMapper(getBaseMapper());
		boolean result = mapper.updateByPrimaryKey(record) > 0;
		session.commit();
		session.close();
		return result;
	}

	//灵活使用多态 ， 泛型
	@Override
	public String searchPaging(SearchParameter params) {
		// 打开数据库
		SqlSession session = MyBatisUtil.getSession();

		//子类向上转型，变为父类(变化一下)
		BaseMapper mapper = session.getMapper(this.getBaseMapper());

		// 查询分页，使用插件mybatis 
		PageHelper.startPage(params.getPage(), params.getSize());

		// 查询你的数据(集合泛型变化)
		List<T> rows = mapper.search(params);

		// 总共有多少数据，使用mybatis插件,为何能强转
		// 看文档
		// https://github.com/pagehelper/Mybatis-PageHelper/blob/master/wikis/zh/HowToUse.md#%E4%BE%8B%E4%B8%80
		Page<T> pg = (Page<T>) rows;
		long total = pg.getTotal(); // 总记录数

		// 最后拼接成 bootstrap-table的json格式 {total:多少笔， rows:集合 }
		JSONObject json = new JSONObject();
		json.put("total", total);
		json.put("rows", rows);

		// 转成json。怕有日期的问题
		String str = JSONObject.toJSONString(json, SerializerFeature.WriteDateUseDateFormat);

		System.out.println(str);
		return str; 
	}

}
