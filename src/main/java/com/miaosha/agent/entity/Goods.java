package com.miaosha.agent.entity;

import lombok.Data;

@Data
public class Goods {
	private Long id;
	private String goodsName;
	private String goodsTitle;
	private String goodsimg;
	private String goodsDetail;
	private Double goodsPrice;
	private Integer goodsStock;

}
