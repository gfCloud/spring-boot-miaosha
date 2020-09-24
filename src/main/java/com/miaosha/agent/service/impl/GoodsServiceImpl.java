package com.miaosha.agent.service.impl;

import com.miaosha.agent.entity.GoodsVo;
import com.miaosha.agent.mapper.GoodsMapper;
import com.miaosha.agent.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * goods
 *
 * @author qiXin
 * @date 2020/9/23
 **/
@Slf4j
@Service
public class GoodsServiceImpl implements GoodsService {
	
	private final GoodsMapper goodsmapper;

	@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
	public GoodsServiceImpl(GoodsMapper goodsmapper) {
		this.goodsmapper = goodsmapper;
	}

	@Override
	public List<GoodsVo> goodsList() {
		return goodsmapper.listGoodsVo();
	}

	@Override
	public GoodsVo getGoodsVoByGoodsId(long goodsId) {
		return goodsmapper.getGoodsVoByGoodsId(goodsId);
	}


}
