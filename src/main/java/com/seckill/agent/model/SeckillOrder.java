package com.seckill.agent.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;

/**
 * seckill_order
 * @author gaoFan
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "seckill_order")
public class SeckillOrder{
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 订单id
     */
    private Integer orderId;

    /**
     * 商品id
     */
    private Integer goodsId;

    private static final long serialVersionUID = 1L;
}