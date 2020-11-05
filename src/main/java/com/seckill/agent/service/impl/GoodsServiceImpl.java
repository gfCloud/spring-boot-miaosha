package com.seckill.agent.service.impl;

import com.seckill.agent.common.service.impl.CommonServiceImpl;
import com.seckill.agent.entity.GoodsVo;
import com.seckill.agent.entity.OrderInfo;
import com.seckill.agent.entity.SeckillUser;
import com.seckill.agent.mapper.GoodsMapper;
import com.seckill.agent.model.SeckillGoods;
import com.seckill.agent.service.GoodsService;
import com.seckill.agent.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * goods
 *
 * @author qiXin
 * @date 2020/9/23
 **/
@Slf4j
@Service
public class GoodsServiceImpl extends CommonServiceImpl<GoodsMapper,SeckillGoods> implements GoodsService {

	@Resource
	private GoodsMapper goodsMapper;
	@Resource
	private OrderService orderService;

	@Override
	public List<GoodsVo> goodsList() {
		return goodsMapper.listGoodsVo();
	}

	@Override
	public GoodsVo getGoodsVoByGoodsId(long goodsId) {
		return goodsMapper.getGoodsVoByGoodsId(goodsId);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public OrderInfo getSeckill(SeckillUser user, GoodsVo goods, HttpServletRequest request) {
		SeckillGoods seckillGoods = new SeckillGoods();
		Example example = new Example(SeckillGoods.class);
		example.createCriteria().andEqualTo("goodsId", goods.getId());
		seckillGoods.setStockCount(goods.getStockCount() - 1);
//		goodsMapper.updateByExampleSelective(seckillGoods, example);
		return orderService.createOrder(user,goods, request);
	}


}
