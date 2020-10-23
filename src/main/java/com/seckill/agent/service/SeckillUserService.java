package com.seckill.agent.service;

import com.seckill.agent.common.service.ICommonService;
import com.seckill.agent.dto.resp.LoginRespDTO;
import com.seckill.agent.entity.LoginUser;
import com.seckill.agent.model.SeckillUser;

import javax.servlet.http.HttpServletResponse;

/**
 * 用户服务层
 *
 * @author qiXin
 * @date 2020/9/23
 **/
public interface SeckillUserService extends ICommonService<SeckillUser, Long> {

	/**
	 * 根据用户ID查询信息
	 * 
	 * @param mobile 用户手机
	 * @return 用户信息
	 */
	LoginRespDTO getByMobile(Long mobile);

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
	LoginRespDTO getByToken(HttpServletResponse response, String token);

	/**
	 * 增加cookie
	 *
	 * @param response 请求
	 * @param token token
	 * @param user 用户实体g
	 */
	void addCookie(HttpServletResponse response, String token, LoginRespDTO user);

}
