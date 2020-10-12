package com.miaosha.agent.entity;

import lombok.Data;

@Data
public class MiaoshaOrder {
	private Long id;
	private Long userld;
	private Long orderid;
	private Long goodsld;
}