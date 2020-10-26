package com.seckill.agent.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author lr-qixin
 * */

@Data
public class GoodsVo{
	private Integer id;
	private BigDecimal secondKillPrice;
	private Integer stockCount;
	private Date startDate;
	private Date endDate;
	private Integer status;
	private Integer seconds;
	private String goodsName;
	private Integer goodsStock;
}
