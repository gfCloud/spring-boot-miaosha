package com.miaosha.agent.service;

import com.miaosha.agent.entity.LoginUser;
import com.miaosha.agent.entity.MiaoShaUser;

import javax.servlet.http.HttpServletResponse;

public interface MiaoshaUserService {

	MiaoShaUser getByid(String id);

	Boolean login(HttpServletResponse repsone, LoginUser miaoshauser);

	MiaoShaUser getBytoken(HttpServletResponse repsone, String token);

	void addCookie(HttpServletResponse repsone, String token, MiaoShaUser user);

}
