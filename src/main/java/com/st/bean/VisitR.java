package com.st.bean;

import java.util.List;

public class VisitR {

	private String visit_id;
	private String visitUserPhone;
	private String visitTime;
	private String visitInfo;
	private String visitPattern;
	private String visitPay;
	private String visitMoney;
	public String getVisit_id() {
		return visit_id;
	}
	public void setVisit_id(String visit_id) {
		this.visit_id = visit_id;
	}
	public String getVisitUserPhone() {
		return visitUserPhone;
	}
	public void setVisitUserPhone(String visitUserPhone) {
		this.visitUserPhone = visitUserPhone;
	}
	public String getVisitTime() {
		return visitTime;
	}
	public void setVisitTime(String visitTime) {
		this.visitTime = visitTime;
	}
	public String getVisitInfo() {
		return visitInfo;
	}
	public void setVisitInfo(String visitInfo) {
		this.visitInfo = visitInfo;
	}
	public String getVisitPattern() {
		return visitPattern;
	}
	public void setVisitPattern(String visitPattern) {
		this.visitPattern = visitPattern;
	}
	public String getVisitPay() {
		return visitPay;
	}
	public void setVisitPay(String visitPay) {
		this.visitPay = visitPay;
	}
	public String getVisitMoney() {
		return visitMoney;
	}
	public void setVisitMoney(String visitMoney) {
		this.visitMoney = visitMoney;
	}
	@Override
	public String toString() {
		return "visitR [visit_id=" + visit_id + ", visitUserPhone=" + visitUserPhone + ", visitTime=" + visitTime
				+ ", visitInfo=" + visitInfo + ", visitPattern=" + visitPattern + ", visitPay=" + visitPay
				+ ", visitMoney=" + visitMoney + "]";
	}
	
}
