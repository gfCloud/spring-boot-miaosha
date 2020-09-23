package com.miaosha.agent.service.impl;

import com.miaosha.agent.controller.LoginController;
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
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

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
	public Boolean login(HttpServletResponse repsone, LoginUser miaoshauser) {
		if (miaoshauser == null) {
			throw new GlobalException(CodeMsg.SERVER_ERROR);
		}
		String id = miaoshauser.getId();
		String fromPass = miaoshauser.getPassword();
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
		addCookie(repsone,token,users);
		return true;
	}

	@Override
	public MiaoShaUser getBytoken(HttpServletResponse repsone, String token) {
		if(StringUtils.isEmpty(token)){
			return null;
		}
		MiaoShaUser user =  redisservice.get(MiaoshaUserKey.token, token, MiaoShaUser.class);
		if(user != null){
			//延长有效期
			addCookie(repsone,token,user);
		}
		return user;
	}


	@Override
	public void addCookie(HttpServletResponse repsone, String token, MiaoShaUser user){
		//把信息放进redis
		redisservice.set(MiaoshaUserKey.token, token, user);
		//设置cookie 
		Cookie cookie = new Cookie(COOKIE_NAME_TOKEN, token);
		cookie.setMaxAge(MiaoshaUserKey.token.expireSeconds());
		cookie.setPath("/");
		repsone.addCookie(cookie);
	}

}
