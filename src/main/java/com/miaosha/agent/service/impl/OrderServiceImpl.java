package com.miaosha.agent.service.impl;

import com.miaosha.agent.entity.GoodsVo;
import com.miaosha.agent.entity.MiaoShaUser;
import com.miaosha.agent.entity.MiaoshaOrder;
import com.miaosha.agent.entity.Orderinfo;
import com.miaosha.agent.mapper.OrderMapper;
import com.miaosha.agent.service.OrderService;
import com.miaosha.agent.until.OrderStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


/**
 * Order
 *
 * @author qiXin
 * @date 2020/9/23
 **/
@Slf4j
@Service
public class OrderServiceImpl  implements OrderService {

    private final OrderMapper orderMapper;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public OrderServiceImpl(OrderMapper orderMapper){
        this.orderMapper = orderMapper;
    }

    @Override
    public MiaoshaOrder getMiaoshaOrderByUserIdGoodsId(long id, long goodsId) {
        return orderMapper.getMiaoshaOrderByUserIdGoodsId(id,goodsId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Orderinfo createOrder(MiaoShaUser user, GoodsVo goods) {
        Orderinfo orderinfo = new Orderinfo();
        Date date = new Date();
        orderinfo.setUserId(user.getId());
        orderinfo.setGoodsId(goods.getId());
        orderinfo.setGoodsName(goods.getGoodsName());
        orderinfo.setGoodsCount(goods.getGoodsStock());
        orderinfo.setGoodsPrice(goods.getMiaoshaPrice());
        orderinfo.setCreateDate(date);
        //订单状态,0新建未支付,1已支付, 2已发货,3已收货,4已退款,5已完成
        orderinfo.setStatus(OrderStatus.CreateOutstandingPayment.orderStatus());
        orderinfo.setOrderChannel(2);
        orderinfo.setDeliverryAddrId(0L);
        Long orderId = orderMapper.createOrder(orderinfo);
        orderinfo.setId(orderId);
        MiaoshaOrder miaoshaOrder = new MiaoshaOrder();
        miaoshaOrder.setOrderId(orderId);
        miaoshaOrder.setGoodsId(goods.getId());
        miaoshaOrder.setUserId(user.getId());
        orderMapper.insertOrderInfo(miaoshaOrder);
        return orderinfo;
    }
}
