package com.seckill.agent.service.impl;

import com.seckill.agent.entity.GoodsVo;
import com.seckill.agent.entity.SeckillOrder;
import com.seckill.agent.entity.SeckillUser;
import com.seckill.agent.entity.OrderInfo;
import com.seckill.agent.mapper.OrderMapper;
import com.seckill.agent.service.OrderService;
import com.seckill.agent.until.OrderNoUtils;
import com.seckill.agent.until.OrderStatus;
import com.seckill.agent.until.UserAgentUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;


/**
 * Order
 *
 * @author qiXin
 * @date 2020/9/23
 **/
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderMapper orderMapper;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public OrderServiceImpl(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Override
    public SeckillOrder getSeckillOrderByUserIdGoodsId(long id, long goodsId) {
        return orderMapper.getSeckillOrderByUserIdGoodsId(id, goodsId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public OrderInfo createOrder(SeckillUser user, GoodsVo goods, HttpServletRequest request) {
        OrderInfo orderinfo = new OrderInfo();
        Date date = new Date();
        orderinfo.setUserId(user.getId());
        orderinfo.setGoodsId(goods.getId());
        orderinfo.setGoodsName(goods.getGoodsName());
        orderinfo.setGoodsCount(goods.getGoodsStock());
        orderinfo.setGoodsPrice(goods.getSecondKillPrice());
        orderinfo.setCreateDate(date);
        //订单状态,0新建未支付,1已支付, 2已发货,3已收货,4已退款,5已完成
        orderinfo.setStatus(OrderStatus.CreateOutstandingPayment.orderStatus());
        orderinfo.setOrderChannel(orderEquipment(request));
        orderinfo.setDeliverryAddrId(0L);
        //生成订单单号
        orderinfo.setOrderNo(OrderNoUtils.getOrderCode(user.getId()));
        //创建订单
        Long orderId = orderMapper.createOrder(orderinfo);
        orderinfo.setId(orderId);
        SeckillOrder seckillOrder = new SeckillOrder();
        seckillOrder.setOrderId(orderId);
        seckillOrder.setGoodsId(goods.getId());
        seckillOrder.setUserId(user.getId());
        //生成秒杀订单
        orderMapper.insertOrderInfo(seckillOrder);
        return orderinfo;
    }

    private int orderEquipment(HttpServletRequest request) {
        //购买设备  1pc, 2手机 , 3平板
        if (UserAgentUtils.isComputer(request)) {
            return 1;
        } else if (UserAgentUtils.isMobile(request)) {
            return 2;
        } else if (UserAgentUtils.isTablet(request)) {
            return 3;
        } else {
            return 0;
        }
    }
}
