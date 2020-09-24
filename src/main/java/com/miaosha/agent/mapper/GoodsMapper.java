package com.miaosha.agent.mapper;

import java.util.List;

import com.miaosha.agent.entity.GoodsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface GoodsMapper {
	
	 List<GoodsVo> listGoodsVo();

	 GoodsVo getGoodsVoByGoodsId(@Param("goodsId") long goodsId);

}
