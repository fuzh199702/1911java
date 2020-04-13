package com.st.bean;

public class Role {

	private String role_id;
	private String roleName;
	private String roleCode;
	public String getRole_id() {
		return role_id;
	}
	public void setRole_id(String role_id) {
		this.role_id = role_id;
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
	@Override
	public String toString() {
		return "Role [role_id=" + role_id + ", roleName=" + roleName + ", roleCode=" + roleCode + "]";
	}
	
	
}
