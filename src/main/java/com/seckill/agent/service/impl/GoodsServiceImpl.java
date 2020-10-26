package com.seckill.agent.service.impl;

import com.seckill.agent.common.service.impl.CommonServiceImpl;
import com.seckill.agent.entity.GoodsVo;
import com.seckill.agent.mapper.GoodsMapper;
import com.seckill.agent.model.SeckillGoods;
import com.seckill.agent.service.GoodsService;
import com.seckill.agent.until.BeanUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * goods
 *
 * @author qiXin
 * @date 2020/9/23
 **/
@Slf4j
@Service
public class GoodsServiceImpl extends CommonServiceImpl<SeckillGoods, Long> implements GoodsService {
	
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

	/*@Override
	public void reduceStock(GoodsVo goods) {
		SeckillGoods seckillGoods = new SeckillGoods();
		Example example = new Example(SeckillGoods.class);
		example.createCriteria().andEqualTo("goodsId", goods.getId());
		seckillGoods.setStockCount(goods.getStockCount() - 1);
		goodsmapper.updateByExampleSelective(seckillGoods,example);
	}*/


}
