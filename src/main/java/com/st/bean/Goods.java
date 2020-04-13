package com.st.bean;

public class Goods {

	private String goods_id;
	private String goodsName;
	private String price;
	public String getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(String goods_id) {
		this.goods_id = goods_id;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Goods [goods_id=" + goods_id + ", goodsName=" + goodsName + ", price=" + price + "]";
	}
	
	
	
}
