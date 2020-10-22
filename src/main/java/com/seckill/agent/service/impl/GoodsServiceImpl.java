package com.seckill.agent.service.impl;

import com.seckill.agent.entity.GoodsVo;
import com.seckill.agent.entity.SeckillGoods;
import com.seckill.agent.mapper.GoodsMapper;
import com.seckill.agent.service.GoodsService;
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

	@Override
	public void reduceStock(GoodsVo goods) {
		SeckillGoods good = new SeckillGoods();
		good.setGoodsId(goods.getId());
		good.setStockCount(goods.getStockCount() - 1);
		goodsmapper.reduceStock(good);
	}


}
