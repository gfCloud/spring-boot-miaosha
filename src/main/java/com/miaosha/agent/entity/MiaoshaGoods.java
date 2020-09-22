package com.miaosha.agent.entity;

import lombok.Data;

import java.util.Date;

@Data
public class MiaoshaGoods {
    private Long id;
    private Long goodsid;
    private double miaoshaPrivce;
    private Integer stockCount;
    private Date startDate;
    private Date endDate;

}