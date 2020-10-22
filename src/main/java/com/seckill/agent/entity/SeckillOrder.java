package com.seckill.agent.entity;

import lombok.Data;

/**
 * @author lr-qixin
 * */
@Data
public class SeckillOrder {
	private Long id;
	private Integer userId;
	private Long orderId;
	private Long goodsId;
}