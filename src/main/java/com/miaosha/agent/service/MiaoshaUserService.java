package com.miaosha.agent.service;

import com.miaosha.agent.entity.LoginUser;
import com.miaosha.agent.entity.MiaoShaUser;

import javax.servlet.http.HttpServletResponse;

/**
 * 用户服务层
 *
 * @author gaoFan
 * @date 2020/9/23
 **/
public interface MiaoshaUserService {

	/**
	 * 根据用户ID查询信息
	 * 
	 * @param id 用户ID
	 * @return 用户信息
	 */
	MiaoShaUser getByid(String id);

	/**
	 * 用户登录
	 *
	 * @param response 请求体
	 * @param loginUser 用户实体
	 */
	void login(HttpServletResponse response, LoginUser loginUser);

	/**
	 * 根据Token查询信息
	 * 
	 * @param response 请求
	 * @param token token
	 * @return token信息
	 */
	MiaoShaUser getByToken(HttpServletResponse response, String token);

	/**
	 * 增加cookie
	 *
	 * @param response 请求
	 * @param token token
	 * @param user 用户实体
	 */
	void addCookie(HttpServletResponse response, String token, MiaoShaUser user);

}
