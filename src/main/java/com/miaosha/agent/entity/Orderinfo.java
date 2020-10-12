package com.miaosha.agent.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Orderinfo {
    private Long id;
    /**
     * 用户id
     */
    private Long userid;
    /**
     * 商品id
     */
    private Long goodsid;
    /**
     * 收货地址id
     */
    private Long deliveryAddrild;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 商品数量
     */
    private Integer goodsCount;
    /**
     * 商品单价
     */
    private Double goodsPrice;
    /**
     * 购买设备  1pc, 2android , 3ios
     */
    private Integer orderChannel;
    /**
     * 订单状态 订单状态,0新建未支付,1已支付, 2已发货,3已收货,4已退款,5已完成
     */
    private Integer status;
    /**
     * 订单创建时间
     */
    private Date createDate;
    /**
     * 支付时间
     */
    private Date payDate;

}