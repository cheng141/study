package com.wisezone.entity;

import java.io.Serializable;

/**
 * 角色管理
 * @author Administrator
 *
 */
public class Role implements Serializable {
	
	private Integer roleId;
	private String roleName;
	private String roleCode;
	private Integer state;

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}
