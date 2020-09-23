package com.miaosha.agent.controller;

import com.miaosha.agent.entity.LoginUser;
import com.miaosha.agent.result.Result;
import com.miaosha.agent.service.MiaoshaUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * 登录
 *
 * @author qiXin
 * @date 2020/09/23
 */
@Controller
@RequestMapping("/main")
public class LoginController {

	@Resource
	private final MiaoshaUserService userService;

	public LoginController(MiaoshaUserService userService) {
		this.userService = userService;
	}

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
