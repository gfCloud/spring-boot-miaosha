package com.seckill.agent.service.impl;

import com.seckill.agent.common.service.impl.CommonServiceImpl;
import com.seckill.agent.entity.GoodsVo;
import com.seckill.agent.entity.OrderInfo;
import com.seckill.agent.entity.SeckillUser;
import com.seckill.agent.mapper.GoodsMapper;
import com.seckill.agent.model.Goods;
import com.seckill.agent.model.SeckillGoods;
import com.seckill.agent.service.OrderService;
import com.seckill.agent.service.SeckillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;

/**
 * goods
 *
 * @author qiXin
 * @date 2020/9/23
 **/
@Slf4j
@Service
public class SeckillServiceImpl extends CommonServiceImpl<Goods, Long> implements SeckillService {

    private final OrderService orderService;

    private final GoodsMapper goodsMapper;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public SeckillServiceImpl(OrderService orderService, GoodsMapper goodsMapper) {
        this.orderService = orderService;
        this.goodsMapper = goodsMapper;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public OrderInfo getSeckill(SeckillUser user, GoodsVo goods, HttpServletRequest request) {
//        goodsService.reduceStock(goods);
        SeckillGoods seckillGoods = new SeckillGoods();
        Example example = new Example(SeckillGoods.class);
        example.createCriteria().andEqualTo("goodsId", goods.getId());
        seckillGoods.setStockCount(goods.getStockCount() - 1);
        goodsMapper.updateByExampleSelective(seckillGoods, example);
        return orderService.createOrder(user,goods, request);
    }


}
