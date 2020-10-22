package com.seckill.agent.entity;

import lombok.Data;

import java.util.Date;
/**
 * @author lr-qixin
 * */
@Data
public class SeckillGoods {
    private Long id;
    private Long goodsId;
    private double secondKillPrice;
    private Integer stockCount;
    private Date startDate;
    private Date endDate;

}