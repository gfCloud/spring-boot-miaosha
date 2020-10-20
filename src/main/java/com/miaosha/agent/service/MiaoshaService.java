package com.miaosha.agent.service.impl;

import com.miaosha.agent.entity.GoodsVo;
import com.miaosha.agent.entity.MiaoShaUser;
import com.miaosha.agent.entity.Orderinfo;

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
     * @return Orderinfo 秒杀订单
     */
    Orderinfo getmiaosha(MiaoShaUser user, GoodsVo goods);

}
