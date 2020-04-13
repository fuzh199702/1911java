package com.st.bean;

public class PermBean {

	private String perm_id;
	private String permCode;
	private String permName;
	private String parent_id;
	public String getPerm_id() {
		return perm_id;
	}
	public void setPerm_id(String perm_id) {
		this.perm_id = perm_id;
	}
	public String getPermCode() {
		return permCode;
	}
	public void setPermCode(String permCode) {
		this.permCode = permCode;
	}
	public String getPermName() {
		return permName;
	}
	public void setPermName(String permName) {
		this.permName = permName;
	}
	public String getParent_id() {
		return parent_id;
	}
	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}
	@Override
	public String toString() {
		return "PermBean [perm_id=" + perm_id + ", permCode=" + permCode + ", permName=" + permName + ", parent_id="
				+ parent_id + "]";
	}
	
	
	
	
}
