package com.wisezone.util.mybatis;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 查询条件，包含分页
 * 
 * @author Administrator
 *
 */
public class SearchParameter {
  
	private String sort; // 排序列
	private String order = ""; // 排序的方式 asc/desc

	private Integer page; //第几页
	private Integer size; //每几笔记

	/**
	 * 查询条件
	 */
	private List<Criterion> searchCriterion = new ArrayList<Criterion>();

	/**
	 * 是给mybatis取值用的 foreach
	 * @return
	 */
	public List<Criterion> getSearchCriterion() {
		return searchCriterion;
	}

	/**
	 * 排序的列
	 * @author:wy
	 * @data:2018-04-02 02:37
	 * @param sort
	 */
	public void setSort(String sort) {
		this.sort = sort;
	}

	/**
	 *排序方式,asc/desc
	 * @author:wy
	 * @data:2018-04-02 02:37
	 * @param order asc升序，desc降序
	 */
	public void setOrder(String order) {
		this.order = order;
	}

	/**
	 * 得到排序的组合
	 * 
	 * @return
	 */
	public String getOrderByClause() {
		// 如果排序列不为空，说明 一定要进行排序的
		if (StringUtils.isNotBlank(this.sort)) {
			return this.sort + " " + this.order;
		}
		return null;
	}

 

	/**
	 * 添加查询条件
	 * @param criterion
	 */
	public void addParameter(Criterion criterion){
		this.searchCriterion.add(criterion);
	}

	public Integer getPage() {
		return page;
	}

	/**
	 * 当前是几页
	 * @param page
	 */
	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getSize() {
		return size;
	}

	/**
	 * 每页显示几笔
	 * @param size
	 */
	public void setSize(Integer size) {
		this.size = size;
	}
}
