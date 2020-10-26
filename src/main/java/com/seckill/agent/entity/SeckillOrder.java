package com.seckill.agent.entity;

import lombok.Data;

/**
 * @author lr-qixin
 * */
@Data
public class SeckillOrder {
	private Integer id;
	private Integer userId;
	private Integer orderId;
	private Integer goodsId;
}