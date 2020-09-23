package com.miaosha.agent.service.impl;

import com.miaosha.agent.entity.LoginUser;
import com.miaosha.agent.entity.MiaoShaUser;
import com.miaosha.agent.exception.GlobalException;
import com.miaosha.agent.mapper.MiaoShaUserMapper;
import com.miaosha.agent.redis.MiaoshaUserKey;
import com.miaosha.agent.redis.RedisService;
import com.miaosha.agent.result.CodeMsg;
import com.miaosha.agent.service.MiaoshaUserService;
import com.miaosha.agent.until.MD5Until;
import com.miaosha.agent.until.UUIDUntil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户
 *
 * @author qiXin
 * @date 2020/9/23
 **/
@Slf4j
@Service
public class MiaoshaUserServiceImpl implements MiaoshaUserService {
	public static final String COOKIE_NAME_TOKEN = "token";

	private final MiaoShaUserMapper userMapper;
	private final RedisService redisservice;

	@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
	public MiaoshaUserServiceImpl(MiaoShaUserMapper userMapper, RedisService redisservice) {
		this.userMapper = userMapper;
		this.redisservice = redisservice;
	}



	@Override
	public MiaoShaUser getByid(String id) {
		return userMapper.getbyID(id);
	}

	@Override
	public void login(HttpServletResponse response, LoginUser loginUser) {
		if (loginUser == null) {
			throw new GlobalException(CodeMsg.SERVER_ERROR);
		}
		String id = loginUser.getId();
		String fromPass = loginUser.getPassword();
		MiaoShaUser users = getByid(id);
		if (users == null) {
			throw new GlobalException(CodeMsg.MOBILE_NOT_EXIST);
		}
		String dbpass = users.getPassword();
		String saltDb = users.getSalt();
		//获取加密之后的密码
		String calcPass = MD5Until.inputPassToDBPass(fromPass, saltDb);
		if (!calcPass.equals(dbpass)) {
			throw new GlobalException(CodeMsg.PASSWORD_ERROR);
		}
		//随机生成uuid
		String token = UUIDUntil.uuid();
		addCookie(response,token,users);
	}

	@Override
	public MiaoShaUser getByToken(HttpServletResponse response, String token) {
		if(StringUtils.isEmpty(token)){
			return null;
		}
		MiaoShaUser user =  redisservice.get(MiaoshaUserKey.token, token, MiaoShaUser.class);
		if(user != null){
			//延长有效期
			addCookie(response,token,user);
		}
		return user;
	}


	@Override
	public void addCookie(HttpServletResponse response, String token, MiaoShaUser user){
		//把信息放进redis
		redisservice.set(MiaoshaUserKey.token, token, user);
		//设置cookie 
		Cookie cookie = new Cookie(COOKIE_NAME_TOKEN, token);
		cookie.setMaxAge(MiaoshaUserKey.token.expireSeconds());
		cookie.setPath("/");
		response.addCookie(cookie);
	}

}
