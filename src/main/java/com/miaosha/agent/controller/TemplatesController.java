package com.miaosha.agent.controller;

import com.miaosha.agent.entity.LoginVo;
import com.miaosha.agent.redis.RedisService;
import com.miaosha.agent.redis.UserKey;
import com.miaosha.agent.result.CodeMsg;
import com.miaosha.agent.result.Result;
import com.miaosha.agent.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * demo
 *
 * @author gaoFan
 * @date 2020/9/23
 **/
@Controller
@RequestMapping("/demo")
public class TemplatesController {

	@Resource
	private final UserService userservice;
	private final RedisService redisSvice;

	public TemplatesController(UserService userservice, RedisService redisSvice) {
		this.userservice = userservice;
		this.redisSvice = redisSvice;
	}

	@GetMapping("/thymeleaf")
	public String thymeleaf(Model model, int id) {
		LoginVo user = userservice.getById(id);
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
	public LoginVo getByid(int id) {
		return userservice.getById(id);
	}

	@PostMapping("/insert")
	@ResponseBody
	public Result<String> insertUser(int id, String name) {
		LoginVo user = new LoginVo();
		user.setId(id);
		user.setName(name);
		int tmp = userservice.insertUser(user);
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
		user.setId(1);
		user.setName(value);
		boolean flag = redisSvice.set(UserKey.getById, str, user);
		return Result.success(flag);
	}

	@GetMapping("/RedisGet")
	@ResponseBody
	public Result<LoginVo> redisGetTestUser(String str) {
		LoginVo user = redisSvice.get(UserKey.getById, str, LoginVo.class);
		return Result.success(user);
	}

}
