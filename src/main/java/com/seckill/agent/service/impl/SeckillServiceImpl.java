package com.seckill.agent.service.impl;

import com.seckill.agent.entity.GoodsVo;
import com.seckill.agent.entity.SeckillUser;
import com.seckill.agent.entity.OrderInfo;
import com.seckill.agent.service.GoodsService;
import com.seckill.agent.service.OrderService;
import com.seckill.agent.service.SeckillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.servlet.http.HttpServletRequest;

/**
 * goods
 *
 * @author qiXin
 * @date 2020/9/23
 **/
@Slf4j
@Service
public class SeckillServiceImpl implements SeckillService {

    private final GoodsService goodsService;

    private final OrderService orderService;

    public SeckillServiceImpl(GoodsService goodsService, OrderService orderService) {
        this.goodsService = goodsService;
        this.orderService = orderService;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public OrderInfo getSeckill(SeckillUser user, GoodsVo goods, HttpServletRequest request) {
        goodsService.reduceStock(goods);
        return orderService.createOrder(user,goods, request);
    }


}
