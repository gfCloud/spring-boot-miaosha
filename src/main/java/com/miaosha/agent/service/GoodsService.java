package com.miaosha.agent.service;

import com.miaosha.agent.entity.GoodsVo;

import java.util.List;

/**
 * goods
 *
 * @author gaoFan
 * @date 2020/9/23
 **/
public interface GoodsService {

    /**
     * 查询goods列表
     * 
     * @return goods列表
     */
    List<GoodsVo> goodsList();

}
