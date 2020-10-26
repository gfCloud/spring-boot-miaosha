package com.seckill.agent.model;

import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * seckill_goods
 * @author 
 */
@Table(name = "seckill_goods")
public class SeckillGoods{
    /**
     * 秒杀的商品表
     */
    private Integer id;

    /**
     * 商品id
     */
    private Integer goodsId;

    /**
     * 秒杀价
     */
    private BigDecimal secondKillPrice;

    /**
     * 库存数量
     */
    private Integer stockCount;

    /**
     * 秒杀开始时间
     */
    private Date startDate;

    /**
     * 秒杀结束时间
     */
    private Date endDate;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public BigDecimal getSecondKillPrice() {
        return secondKillPrice;
    }

    public void setSecondKillPrice(BigDecimal secondKillPrice) {
        this.secondKillPrice = secondKillPrice;
    }

    public Integer getStockCount() {
        return stockCount;
    }

    public void setStockCount(Integer stockCount) {
        this.stockCount = stockCount;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}