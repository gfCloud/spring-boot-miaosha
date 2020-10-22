package com.seckill.agent.controller;

import com.seckill.agent.consts.CurrencyConsts;
import com.seckill.agent.dto.req.LoginUserDTO;
import com.seckill.agent.entity.LoginVo;
import com.seckill.agent.redis.RedisService;
import com.seckill.agent.redis.UserKey;
import com.seckill.agent.result.CodeMsg;
import com.seckill.agent.result.Result;
import com.seckill.agent.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * demo
 *
 * @author qiXin
 * @date 2020/9/23
 **/
@Controller
@RequestMapping("/demo")
public class TemplatesController {

	@Resource
	private final UserService userservice;
	private final RedisService redisService;

	public TemplatesController(UserService userservice, RedisService redisSvice) {
		this.userservice = userservice;
		this.redisService = redisSvice;
	}

	@GetMapping("/thymeleaf")
	public String thymeleaf(Model model, Long mobile) {
		LoginVo user = userservice.getById(mobile);
		model.addAttribute("id", user.getId());
		model.addAttribute("name", user.getName());
		return "demo";
	}

	@GetMapping("/success")
	@ResponseBody
	public Result<String> success() {
		return Result.success("seccess成功返回");
	}

	@GetMapping("/error")
	@ResponseBody
	public Result<String> error() {
		return Result.error(CodeMsg.SERVER_ERROR);
	}

	@GetMapping("/get")
	@ResponseBody
	public LoginVo getById(Long mobile) {
		return userservice.getById(mobile);
	}

	@PostMapping("/insert")
	@ResponseBody
	public Result<String> insertUser(@RequestBody @Valid LoginUserDTO loginUserDTO) {
		int tmp = userservice.insertUser(loginUserDTO);
		if (tmp == 1) {
			return Result.success("插入成功");
		} else {
			return Result.error(CodeMsg.BIND_SERVER);
		}
	}

	@GetMapping("/RedisSet")
	@ResponseBody
	public Result<Boolean> redisSetTest(String str, String value) {
		LoginVo user = new LoginVo();
		user.setId(CurrencyConsts.ONE);
		user.setName(value);
		boolean flag = redisService.set(UserKey.getById, str, user);
		return Result.success(flag);
	}

	@GetMapping("/RedisGet")
	@ResponseBody
	public Result<LoginVo> redisGetTestUser(String str) {
		LoginVo user = redisService.get(UserKey.getById, str, LoginVo.class);
		return Result.success(user);
	}

}
