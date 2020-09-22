package com.qixin.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qixin.entity.LoginVo;
import com.qixin.redis.RedisService;
import com.qixin.redis.UserKey;
import com.qixin.result.CodeMsg;
import com.qixin.result.Result;
import com.qixin.service.UserService;

@Controller
@RequestMapping("/demo")
public class TemplatesController {

	@Autowired
	private UserService userservice;

	@Autowired
	RedisService redisSvice;

	@RequestMapping("/thymeleaf")
	public String thymeleaf(Model model, int id) {
		LoginVo user = userservice.getByID(id);
		model.addAttribute("id", user.getId());
		model.addAttribute("name", user.getName());
		return "demo";
	}

	@RequestMapping("/success")
	@ResponseBody
	public Result<String> success() {
		return Result.success("seccess成功返回");
	}

	@RequestMapping("/error")
	@ResponseBody
	public Result<String> error() {
		return Result.error(CodeMsg.SERVER_ERROR);
	}

	@RequestMapping("/get")
	@ResponseBody
	public LoginVo getByid(int id) {
		return userservice.getByID(id);
	}

	@RequestMapping("/Insert")
	@ResponseBody
	public Result<String> InsertUser(int id, String name) throws Exception {
		LoginVo user = new LoginVo();
		user.setId(id);
		user.setName(name);
		int tmp = userservice.InsertUser(user);
		if (tmp == 1) {
			return Result.success("插入成功");
		} else {
			return Result.error(CodeMsg.BIND_SERVER);
		}
	}

	@RequestMapping("/RedisSet")
	@ResponseBody
	public Result<Boolean> redisSetTest(String str, String value) {
		LoginVo user = new LoginVo();
		user.setId(1);
		user.setName(value);
		boolean flag = redisSvice.set(UserKey.getById, str, user);
		return Result.success(flag);
	}

	@RequestMapping("/RedisGet")
	@ResponseBody
	public Result<LoginVo> redisGetTestUser(String str) {
		LoginVo user = redisSvice.get(UserKey.getById, str, LoginVo.class);
		return Result.success(user);
	}

}
