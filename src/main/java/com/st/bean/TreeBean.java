package com.st.bean;

import java.util.List;

public class TreeBean {

	private String perm_id;
	private String permName;
	private String id;
	private String title;
	private List<TreeBean> children;
	public String getPerm_id() {
		return perm_id;
	}
	public void setPerm_id(String perm_id) {
		this.perm_id = perm_id;
	}
	public String getPermName() {
		return permName;
	}
	public void setPermName(String permName) {
		this.permName = permName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<TreeBean> getChildren() {
		return children;
	}
	public void setChildren(List<TreeBean> children) {
		this.children = children;
	}
	@Override
	public String toString() {
		return "TreeBean [perm_id=" + perm_id + ", permName=" + permName + ", id=" + id + ", title=" + title
				+ ", children=" + children + "]";
	}
	
	
}
