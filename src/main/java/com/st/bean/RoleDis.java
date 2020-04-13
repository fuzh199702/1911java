package com.st.bean;

public class RoleDis {

	private String value;
	private String title;
	private String roleCode;
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	@Override
	public String toString() {
		return "RoleDis [value=" + value + ", title=" + title + ", roleCode=" + roleCode + "]";
	}
	
	
	
}
