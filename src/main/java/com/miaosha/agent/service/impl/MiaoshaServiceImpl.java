package com.miaosha.agent.service.impl;

import com.miaosha.agent.entity.GoodsVo;
import com.miaosha.agent.entity.MiaoShaUser;
import com.miaosha.agent.entity.OrderInfo;
import com.miaosha.agent.service.GoodsService;
import com.miaosha.agent.service.MiaoshaService;
import com.miaosha.agent.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
public class MiaoshaServiceImpl implements MiaoshaService {

    @Autowired
    GoodsService goodsService;

    @Autowired
    OrderService orderService;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public OrderInfo getmiaosha(MiaoShaUser user, GoodsVo goods,HttpServletRequest request) {
        goodsService.reduceStock(goods);
        return orderService.createOrder(user,goods, request);
    }


}
