package com.miaosha.agent.mapper;

import java.util.List;

import com.miaosha.agent.entity.GoodsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface GoodsMapper {

	/**
	 * 查询商品列表
	 * @return goods列表
	 */
	 List<GoodsVo> listGoodsVo();

	/**
	 * 根据id查询商品详细信息
	 * @param goodsId 商品id
	 * @return goods列表
	 */
	 GoodsVo getGoodsVoByGoodsId(@Param("goodsId") long goodsId);

}
