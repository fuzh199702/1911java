package com.st.bean;

import java.util.List;

public class GoodsType {

	private String goodsType_id;
	private String goodsTypeName;
	private List<Goods> goodsList;
	public String getGoodsType_id() {
		return goodsType_id;
	}
	public void setGoodsType_id(String goodsType_id) {
		this.goodsType_id = goodsType_id;
	}
	public String getGoodsTypeName() {
		return goodsTypeName;
	}
	public void setGoodsTypeName(String goodsTypeName) {
		this.goodsTypeName = goodsTypeName;
	}
	public List<Goods> getGoodsList() {
		return goodsList;
	}
	public void setGoodsList(List<Goods> goodsList) {
		this.goodsList = goodsList;
	}
	@Override
	public String toString() {
		return "GoodsType [goodsType_id=" + goodsType_id + ", goodsTypeName=" + goodsTypeName + ", goodsList="
				+ goodsList + "]";
	}
	
	
	
}
