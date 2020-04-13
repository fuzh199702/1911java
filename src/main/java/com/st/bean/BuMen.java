package com.st.bean;

import java.util.List;

public class BuMen {

	private String bm_id;
	private String bmName;
	private String manager;
	private List<UserBean> userList;
	
	
	public String getBm_id() {
		return bm_id;
	}
	public void setBm_id(String bm_id) {
		this.bm_id = bm_id;
	}
	public String getBmName() {
		return bmName;
	}
	public void setBmName(String bmName) {
		this.bmName = bmName;
	}
	public List<UserBean> getUserList() {
		return userList;
	}
	public void setUserList(List<UserBean> userList) {
		this.userList = userList;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	@Override
	public String toString() {
		return "BuMen [bm_id=" + bm_id + ", bmName=" + bmName + ", manager=" + manager + ", userList=" + userList + "]";
	}
	
	
}
