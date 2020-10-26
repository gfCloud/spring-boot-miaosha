package com.seckill.agent.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author lr-qixin
 * */

@Data
@EqualsAndHashCode(callSuper = true)
public class GoodsVo extends Goods {
	private Double secondKillPrice;
	private Integer stockCount;
	private Date startDate;
	private Date endDate;
	private Integer status;
	private Integer seconds;
}
