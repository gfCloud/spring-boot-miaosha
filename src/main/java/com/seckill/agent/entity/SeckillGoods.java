package com.seckill.agent.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
/**
 * @author lr-qixin
 * */
@Data
public class SeckillGoods {
    private Integer id;
    private Integer goodsId;
    private BigDecimal secondKillPrice;
    private Integer stockCount;
    private Date startDate;
    private Date endDate;

}