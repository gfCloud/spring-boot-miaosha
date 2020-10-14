package com.miaosha.agent.entity;

import lombok.Data;

/**
 * @author lr-qixin
 * */
@Data
public class MiaoshaOrder {
	private Long id;
	private Long userId;
	private Long orderId;
	private Long goodsId;
}