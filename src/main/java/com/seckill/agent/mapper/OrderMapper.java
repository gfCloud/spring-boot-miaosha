package com.seckill.agent.mapper;

import com.seckill.agent.common.mapper.MyMapper;
import com.seckill.agent.dto.resp.SeckillOrderRespDTO;
import com.seckill.agent.entity.OrderInfo;
import com.seckill.agent.model.SeckillOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author qixin
 * 订单
 */
@Mapper
public interface OrderMapper extends MyMapper<SeckillOrder> {

    /**
     * 查询商品是否已被当前用户秒杀过
     *
     * @param id
     * @param goodsId
     * @return seckillOrder 秒杀订单
     */
    SeckillOrderRespDTO getSeckillOrderByUserIdGoodsId(@Param("id") long id, @Param("goodsId") long goodsId);

    /**
     * 创建订单信息
     *
     * @param orderinfo 订单信息
     * @return OrderInfo
     */
    int createOrder(OrderInfo orderinfo);

    /**
     * 创建订单信息
     *
     * @param seckillOrder 秒杀订单信息
     * @return OrderInfo
     */
    void insertOrderInfo(SeckillOrder seckillOrder);
}
