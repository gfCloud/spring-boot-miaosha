package com.qixin.entity;

import java.util.Date;

public class MiaoshaGoods {
	private Long id;
	private Long goodsid;
	private double miaoshaPrivce;
	private Integer stockCount;
	private Date startDate;
	private Date endDate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(Long goodsid) {
		this.goodsid = goodsid;
	}
	public double getMiaoshaPrivce() {
		return miaoshaPrivce;
	}
	public void setMiaoshaPrivce(double miaoshaPrivce) {
		this.miaoshaPrivce = miaoshaPrivce;
	}
	public Integer getStockCount() {
		return stockCount;
	}
	public void setStockCount(Integer stockCount) {
		this.stockCount = stockCount;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
}