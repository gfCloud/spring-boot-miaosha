package com.seckill.agent.mapper;

import com.seckill.agent.common.mapper.MyMapper;
import com.seckill.agent.entity.GoodsVo;
import com.seckill.agent.entity.SeckillGoods;
import com.seckill.agent.model.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author qixin
 * 商品查询
 */
@Mapper
public interface GoodsMapper extends MyMapper<Goods> {

    /**
     * 查询商品列表
     *
     * @return goods列表
     */
    List<GoodsVo> listGoodsVo();

    /**
     * 根据id查询商品详细信息
     *
     * @param goodsId 商品id
     * @return goods列表
     */
    GoodsVo getGoodsVoByGoodsId(@Param("goodsId") long goodsId);

    /**
     * 修改库存信息
     *
     * @param good 商品
     * @return int
     */
    int reduceStock(SeckillGoods good);
}
