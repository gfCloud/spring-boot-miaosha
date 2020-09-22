package com.qixin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.qixin.entity.GoodsVo;

@Mapper
public interface GoodsMapper {
	
	public List<GoodsVo> listGoodsVo();

}
