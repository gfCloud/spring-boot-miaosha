package com.miaosha.agent.entity;

import lombok.Data;

import java.util.Date;

@Data
public class GoodsVo extends Goods {
	private Double miaoshaPrice;
	private Integer stockCount;
	private Date startDate;
	private Date endDate;
	
}
