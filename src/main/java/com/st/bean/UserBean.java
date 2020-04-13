package com.st.bean;

public class UserBean {

	private String user_id;
	private String userName;
	private String passWord;
	private String phoneNo;
	
	
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "UserBean [user_id=" + user_id + ", userName=" + userName + ", passWord=" + passWord + ", phoneNo="
				+ phoneNo + "]";
	}
	
}
