package com.miaosha.agent.controller;

import com.miaosha.agent.entity.MiaoShaUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 菜单
 *
 * @author gaoFan
 * @date 2020/09/25
 */
@Controller
@RequestMapping("/menu")
public class MenuController {

	@GetMapping("/toMenu")
	public String toMenu(Model model, MiaoShaUser user){
		model.addAttribute("user",  user);
		return "/index";
	}


}
