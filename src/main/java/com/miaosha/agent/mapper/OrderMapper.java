package com.miaosha.agent.mapper;

import com.miaosha.agent.entity.MiaoshaOrder;
import com.miaosha.agent.entity.Orderinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author qixin
 * 订单
 */
@Mapper
public interface OrderMapper {

    /**
     * 查询商品是否已被当前用户秒杀过
     *
     * @param id
     * @param goodsId
     * @return MiaoshaOrder 秒杀订单
     */
    MiaoshaOrder getMiaoshaOrderByUserIdGoodsId(@Param("id") long id, @Param("goodsId") long goodsId);

    /**
     * 创建订单信息
     *
     * @param orderinfo 订单信息
     * @return Orderinfo
     */
    long createOrder(Orderinfo orderinfo);

    /**
     * 创建订单信息
     *
     * @param miaoshaOrder 秒杀订单信息
     * @return Orderinfo
     */
    void insertOrderInfo(MiaoshaOrder miaoshaOrder);
}
