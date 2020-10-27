package com.seckill.agent.dto.resp;

import lombok.Data;

/**
 * @author lr-qixin
 * */
@Data
public class SeckillOrderRespDTO {
	private Integer id;
	private Integer userId;
	private Integer orderId;
	private Integer goodsId;
}