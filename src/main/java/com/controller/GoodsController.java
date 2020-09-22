package com.qixin.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.druid.util.StringUtils;
import com.qixin.entity.GoodsVo;
import com.qixin.entity.MiaoShaUser;
import com.qixin.service.GoodsService;
import com.qixin.service.MiaoshaUserService;


@Controller
@RequestMapping("/goods")
public class GoodsController {
	
	@Autowired
	MiaoshaUserService userservice;
	
	@Autowired
	GoodsService goodsService;
	
	@RequestMapping("/to_list")
	public String to_List(Model model,MiaoShaUser user){
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
