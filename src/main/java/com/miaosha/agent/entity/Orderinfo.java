package com.miaosha.agent.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Orderinfo {
    private Long id;
    private Long userid;
    private Long goodsid;
    private Long deliveryAddrild;
    private String goodsName;
    private Integer goodsCount;
    private Double goodsPrice;
    private Integer orderChannel;
    private Integer status;
    private Date createDate;
    private Date payDate;

}