package com.miaosha.agent.controller;

import com.miaosha.agent.entity.GoodsVo;
import com.miaosha.agent.entity.MiaoShaUser;
import com.miaosha.agent.service.GoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * goods class
 *
 * @author qiXin
 * @date 2020/09/23
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {

	private final GoodsService goodsService;

	public GoodsController(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

	@GetMapping("/toList")
	public String toList(Model model, MiaoShaUser user){
		model.addAttribute("user",  user);
		List<GoodsVo> goodsList = goodsService.goodsList();
		model.addAttribute("goodsList", goodsList);
		return "goods/goods_list";
	}

	@GetMapping("/toDetail/{goodsId}")
	public String toDetail(Model model, MiaoShaUser user, @PathVariable("goodsId") long goodsId){
		model.addAttribute("user",  user);
		GoodsVo goods = goodsService.getGoodsVoByGoodsId(goodsId);
		model.addAttribute("goods",  goods);
		long startAt = goods.getStartDate().getTime();
		long endAt = goods.getEndDate().getTime();
		long nowAt = System.currentTimeMillis();
		//0 还没开始 1秒杀中 2秒杀结束
		int miaoShaStatus;
		int remainSeconds;
		if(nowAt < startAt){
			//秒杀还没开
			miaoShaStatus = 0;
			remainSeconds = (int)(startAt - nowAt)/ 1000;
		}else if(nowAt > endAt){
			//秒杀已经结束
			miaoShaStatus = 2;
			remainSeconds = -1;
		}else{
			//秒杀中
			miaoShaStatus = 1;
			remainSeconds = 0;
		}
		model.addAttribute("miaoShaStatus",  miaoShaStatus);
		model.addAttribute("remainSeconds",  remainSeconds);
		return "goods/goods_detail";
	} 
	

}
