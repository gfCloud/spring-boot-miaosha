package com.miaosha.agent.service;

import com.miaosha.agent.entity.GoodsVo;
import com.miaosha.agent.entity.MiaoShaUser;
import com.miaosha.agent.entity.OrderInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * goods
 *
 * @author qiXin
 * @date 2020/9/23
 **/
public interface MiaoshaService {

    /**
     * 查询goods列表
     * @param user 当前用户
     * @param goods 当前商品
     * @param  request 请求
     * @return OrderInfo 秒杀订单
     */
    OrderInfo getmiaosha(MiaoShaUser user, GoodsVo goods, HttpServletRequest request);

}
