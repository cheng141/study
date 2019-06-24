package com.wisezone.util.mybatis;

/**
 * 查询的标准
 * 
 * @author Administrator
 *
 */
public class Criterion {

	private String columnName; // 数据库的列名
	private Object value; // 数据库查询的值
	private OptionEnum condition; // 条件(>,>=, <,<=,!=,in,not in,null,not
									// null,like )

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public Object getValue() {
		//解决为空和不为空取值的问题
		if(this.getCondition()==OptionEnum.nil || this.getCondition()==OptionEnum.nnil){
			return "";
		}
  
        
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public OptionEnum getCondition() {
		return condition;
	}

	public void setCondition(OptionEnum condition) {
		this.condition = condition;
	}

	/**
	 * 构造函数
	 * 
	 * @param columnName
	 *            查询的列名
	 * @param condition
	 *            条件
	 * @param value
	 *            值
	 */
	public Criterion(String columnName, OptionEnum condition, Object value) {
		super();
		this.columnName = columnName;
		this.value = value;
		this.condition = condition;
	}

	public Criterion() {
		super();
	}

}
