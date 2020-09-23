package com.miaosha.agent.controller;

import com.miaosha.agent.entity.LoginUser;
import com.miaosha.agent.result.Result;
import com.miaosha.agent.service.MiaoshaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@RequestMapping("/main")
public class LoginController {
	
	@Autowired
	MiaoshaUserService userService;

	@GetMapping("/toLogin")
	public String toLogin(){
		return "login";
	}
	
	@PostMapping("/doLogin")
	@ResponseBody
	public Result<Boolean> doLogin(HttpServletResponse response, @Valid LoginUser user){
		userService.login(response,user);
		return Result.success(true);
	}
	
	
	
}
