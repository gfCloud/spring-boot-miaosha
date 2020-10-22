package com.seckill.agent.service;


import com.seckill.agent.entity.GoodsVo;
import com.seckill.agent.entity.OrderInfo;
import com.seckill.agent.entity.SeckillUser;

import javax.servlet.http.HttpServletRequest;

/**
 * goods
 *
 * @author qiXin
 * @date 2020/9/23
 **/
public interface SeckillService {

    /**
     * 查询goods列表
     * @param user 当前用户
     * @param goods 当前商品
     * @param  request 请求
     * @return OrderInfo 秒杀订单
     */
    OrderInfo getSeckill(SeckillUser user, GoodsVo goods, HttpServletRequest request);

}
