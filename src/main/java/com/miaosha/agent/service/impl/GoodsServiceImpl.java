package com.miaosha.agent.service.impl;

import com.miaosha.agent.entity.GoodsVo;
import com.miaosha.agent.mapper.GoodsMapper;
import com.miaosha.agent.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class GoodsServiceImpl implements GoodsService {
	
	private final GoodsMapper goodsmapper;

	@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
	public GoodsServiceImpl(GoodsMapper goodsmapper) {
		this.goodsmapper = goodsmapper;
	}

	@Override
	public List<GoodsVo> GoodsList() {
		return goodsmapper.listGoodsVo();
	}
	
	

}
