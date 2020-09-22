package com.qixin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qixin.entity.GoodsVo;
import com.qixin.mapper.GoodsMapper;

@Service
public class GoodsService {
	
	@Autowired
	GoodsMapper goodsmapper;
	
	public List<GoodsVo> GoodsList(){
		return goodsmapper.listGoodsVo();
	}
	
	

}
