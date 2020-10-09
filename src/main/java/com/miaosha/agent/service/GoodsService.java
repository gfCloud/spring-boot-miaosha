package com.miaosha.agent.service;

import com.miaosha.agent.entity.GoodsVo;

import java.util.List;

/**
 * goods
 *
 * @author qiXin
 * @date 2020/9/23
 **/
public interface GoodsService {

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
}
