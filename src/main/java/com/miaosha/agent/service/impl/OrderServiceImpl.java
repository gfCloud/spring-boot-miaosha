package com.miaosha.agent.service.impl;

import com.miaosha.agent.entity.GoodsVo;
import com.miaosha.agent.entity.MiaoShaUser;
import com.miaosha.agent.entity.MiaoshaOrder;
import com.miaosha.agent.entity.OrderInfo;
import com.miaosha.agent.mapper.OrderMapper;
import com.miaosha.agent.service.OrderService;
import com.miaosha.agent.until.OrderNoUtils;
import com.miaosha.agent.until.OrderStatus;
import com.miaosha.agent.until.UserAgentUtils;
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
    public MiaoshaOrder getMiaoshaOrderByUserIdGoodsId(long id, long goodsId) {
        return orderMapper.getMiaoshaOrderByUserIdGoodsId(id, goodsId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public OrderInfo createOrder(MiaoShaUser user, GoodsVo goods, HttpServletRequest request) {
        OrderInfo orderinfo = new OrderInfo();
        Date date = new Date();
        orderinfo.setUserId(user.getId());
        orderinfo.setGoodsId(goods.getId());
        orderinfo.setGoodsName(goods.getGoodsName());
        orderinfo.setGoodsCount(goods.getGoodsStock());
        orderinfo.setGoodsPrice(goods.getMiaoshaPrice());
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
        MiaoshaOrder miaoshaOrder = new MiaoshaOrder();
        miaoshaOrder.setOrderId(orderId);
        miaoshaOrder.setGoodsId(goods.getId());
        miaoshaOrder.setUserId(user.getId());
        //生成秒杀订单
        orderMapper.insertOrderInfo(miaoshaOrder);
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
