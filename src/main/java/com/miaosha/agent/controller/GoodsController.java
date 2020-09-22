package com.miaosha.agent.controller;

import java.util.List;

import com.miaosha.agent.entity.GoodsVo;
import com.miaosha.agent.entity.MiaoShaUser;
import com.miaosha.agent.service.GoodsService;
import com.miaosha.agent.service.MiaoshaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/goods")
public class GoodsController {
	
	@Autowired
    MiaoshaUserService userservice;
	
	@Autowired
    GoodsService goodsService;
	
	@RequestMapping("/to_list")
	public String to_List(Model model, MiaoShaUser user){
		model.addAttribute("user",  user);
		List<GoodsVo> goodsList = goodsService.GoodsList();
		model.addAttribute("goodsList", goodsList);
		return "goods_list";
	}
	
	@RequestMapping("/to_detail")
	public String to_detail(Model model,MiaoShaUser user){
		return "goods_list";
	} 
	
	
	
	
	
	

}
