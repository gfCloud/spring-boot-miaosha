package com.miaosha.agent.entity;

import lombok.Data;

/**
 * @author lr-qixin
 * */
@Data
public class Goods {
	private Long id;
	private String goodsName;
	private String goodsTitle;
	private String goodsImg;
	private String goodsDetail;
	private Double goodsPrice;
	private Integer goodsStock;

}
