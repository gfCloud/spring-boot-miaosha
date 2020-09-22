package com.qixin.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qixin.controller.LoginController;
import com.qixin.entity.LoginUser;
import com.qixin.entity.MiaoShaUser;
import com.qixin.exception.GlobalException;
import com.qixin.mapper.MiaoShaUserMapper;
import com.qixin.redis.MiaoshaUserKey;
import com.qixin.redis.RedisService;
import com.qixin.result.CodeMsg;
import com.qixin.until.MD5Until;
import com.qixin.until.UUIDUntil;

@Service
public class MiaoshaUserService {

	private static Logger log = LoggerFactory.getLogger(LoginController.class);
	
	public static final String COOKIE_NAME_TOKEN = "token";

	@Autowired
	MiaoShaUserMapper userMapper;
	
	@Autowired
	RedisService redisservice;

	public MiaoShaUser getByid(String id) {
		return userMapper.getbyID(id);
	};

	public Boolean login(HttpServletResponse repsone,LoginUser miaoshauser) {
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

	public MiaoShaUser getBytoken(HttpServletResponse repsone,String token) {
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
	
	
	private void addCookie(HttpServletResponse repsone,String token,MiaoShaUser user){
		//把信息放进redis
		redisservice.set(MiaoshaUserKey.token, token, user);
		//设置cookie 
		Cookie cookie = new Cookie(COOKIE_NAME_TOKEN, token);
		cookie.setMaxAge(MiaoshaUserKey.token.expireSeconds());
		cookie.setPath("/");
		repsone.addCookie(cookie);
	}

}
