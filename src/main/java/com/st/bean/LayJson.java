package com.st.bean;

import java.util.List;


public class LayJson {

	public LayJson(List data) {
		super();
//		if(data!=null) {
//			this.count=data.size();
//		}
		this.data = data;
	}
//	public LayJson(GoodsT g) {
//		// TODO Auto-generated constructor stub
//	}
	private String code="0";
	private String msg="";
	private int count=0;
	private List data=null;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List getData() {
		return data;
	}
	public void setData(List data) {
//		if(data!=null) {
//			this.count=data.size();
//		}
		this.data = data;
	}
	@Override
	public String toString() {
		return "LayJson [code=" + code + ", msg=" + msg + ", count=" + count + ", data=" + data + "]";
	}
	
}
