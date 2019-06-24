package com.wisezone.util.mybatis;

/**
 * 条件枚举
 * 
 * @author Administrator
 *
 */
public enum OptionEnum {

	/**
	 * 等于
	 */
	eq(" = ", 1),
	/**
	 * 大于
	 */
	gt(" > ", 2),
	/**
	 * 小于
	 */
	lt(" < ", 3),
	/**
	 * 大于等于
	 */
	gte(" >= ", 4),
	/**
	 * 小于等于
	 */
	lte(" <= ", 5),
	/**
	 * 不等于
	 */
	neq(" != ", 6),
	/**
	 * like 
	 */
	like(" like ",7), 
	/**
	 * in
	 */
	in(" in", 8), 
	/**
	 * not in
	 */
	nin(" not in", 9),
	/**
	 * 为null
	 */
	nil(" is null ", 10),
	/**
	 * 不为null
	 */
	nnil(" is not null ", 11);

	private String name; // 变量名
	private int index; // 下标

	private OptionEnum(String name, int index) {
		this.name = name;
		this.index = index;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	
}
