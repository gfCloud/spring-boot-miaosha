package com.seckill.agent.service;

import com.seckill.agent.common.service.ICommonService;
import com.seckill.agent.entity.GoodsVo;
import com.seckill.agent.entity.OrderInfo;
import com.seckill.agent.entity.SeckillUser;
import com.seckill.agent.model.SeckillGoods;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * goods
 *
 * @author qiXin
 * @date 2020/9/23
 **/
public interface GoodsService extends ICommonService<SeckillGoods, Long> {

    /**
     * 查询goods列表
     *
     * @return goods列表
     */
    List<GoodsVo> goodsList();

    /**
     * 根据id查询商品详细信息
     * @param goodsId 商品id
     * @return goods列表
     */
    GoodsVo getGoodsVoByGoodsId(long goodsId);

    /**
     * 根据id查询商品详细信息
     * @param goods 商品
     * @return GoodsVo
     */
//    void reduceStock(GoodsVo goods);


    /**
     * 查询goods列表
     * @param user 当前用户
     * @param goods 当前商品
     * @param  request 请求
     * @return OrderInfo 秒杀订单
     */
    OrderInfo getSeckill(SeckillUser user, GoodsVo goods, HttpServletRequest request);

}
