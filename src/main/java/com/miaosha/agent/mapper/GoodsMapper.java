package com.miaosha.agent.mapper;

import java.util.List;

import com.miaosha.agent.entity.GoodsVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GoodsMapper {
	
	 List<GoodsVo> listGoodsVo();

}
