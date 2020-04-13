package com.st.bean;

import java.util.List;

public class Customer {

	private String customer_id;
	private String customerName;
	private String contactName;
	private String customerTel;
	private String customerEmail;
	private String customerAddr;
	private String state;
	private String customerGrade;
	private String createTime;
	private String userPhone;
	private String customerPublic;
	
	
	
	public String getCustomerPublic() {
		return customerPublic;
	}
	public void setCustomerPublic(String customerPublic) {
		this.customerPublic = customerPublic;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getCustomerTel() {
		return customerTel;
	}
	public void setCustomerTel(String customerTel) {
		this.customerTel = customerTel;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getCustomerAddr() {
		return customerAddr;
	}
	public void setCustomerAddr(String customerAddr) {
		this.customerAddr = customerAddr;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCustomerGrade() {
		return customerGrade;
	}
	public void setCustomerGrade(String customerGrade) {
		this.customerGrade = customerGrade;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", customerName=" + customerName + ", contactName="
				+ contactName + ", customerTel=" + customerTel + ", customerEmail=" + customerEmail + ", customerAddr="
				+ customerAddr + ", state=" + state + ", customerGrade=" + customerGrade + ", createTime=" + createTime
				+ ", userPhone=" + userPhone + ", customerPublic=" + customerPublic + "]";
	}
	
}
