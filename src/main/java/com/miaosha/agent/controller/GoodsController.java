package com.miaosha.agent.controller;

import com.miaosha.agent.entity.GoodsVo;
import com.miaosha.agent.entity.MiaoShaUser;
import com.miaosha.agent.service.GoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * goods class
 *
 * @author gaofan
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
		return "goods_list";
	}

	@GetMapping("/toDetail")
	public String toDetail(){
		return "goods_list";
	} 
	

}
