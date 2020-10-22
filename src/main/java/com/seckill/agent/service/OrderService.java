package com.seckill.agent.service;

import com.seckill.agent.entity.GoodsVo;
import com.seckill.agent.entity.SeckillOrder;
import com.seckill.agent.entity.SeckillUser;
import com.seckill.agent.entity.OrderInfo;

import javax.servlet.http.HttpServletRequest;


/**
 * goods
 *
 * @author qiXin
 * @date 2020/10/09
 **/
public interface OrderService {

    /**
     * 查询商品是否被当前用户秒杀到
     * @param id 用户id
     * @param goodsId 商品id
     * @return goods列表
     */
    SeckillOrder getSeckillOrderByUserIdGoodsId(long id, long goodsId);

    /**
     *  生成订单
     * @param user 用户
     * @param goods 商品
     * @param request 请求
     * @return goods列表
     */
    OrderInfo createOrder(SeckillUser user, GoodsVo goods, HttpServletRequest request);
}
