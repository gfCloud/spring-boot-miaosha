package com.miaosha.agent.service;

import java.util.List;

import com.miaosha.agent.entity.GoodsVo;
import com.miaosha.agent.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsService {
	
	@Autowired
    GoodsMapper goodsmapper;
	
	public List<GoodsVo> GoodsList(){
		return goodsmapper.listGoodsVo();
	}
	
	

}
