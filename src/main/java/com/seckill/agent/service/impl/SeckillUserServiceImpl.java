package com.seckill.agent.service.impl;

import com.seckill.agent.entity.LoginUser;
import com.seckill.agent.entity.SeckillUser;
import com.seckill.agent.exception.GlobalException;
import com.seckill.agent.mapper.SeckillUserMapper;
import com.seckill.agent.redis.SeckillUserKey;
import com.seckill.agent.redis.RedisService;
import com.seckill.agent.result.CodeMsg;
import com.seckill.agent.service.SeckillUserService;
import com.seckill.agent.until.MD5Until;
import com.seckill.agent.until.UUIDUntil;
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
public class SeckillUserServiceImpl implements SeckillUserService {
    public static final String COOKIE_NAME_TOKEN = "token";

    private final SeckillUserMapper seckilluserMapper;
    private final RedisService redisservice;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public SeckillUserServiceImpl(SeckillUserMapper seckilluserMapper, RedisService redisservice) {
        this.seckilluserMapper = seckilluserMapper;
        this.redisservice = redisservice;
    }

    @Override
    public SeckillUser getByMobile(Long mobile) {
        return seckilluserMapper.getByMobile(mobile);
    }

    @Override
    public void login(HttpServletResponse response, LoginUser loginUser) {
        if (loginUser == null) {
            throw new GlobalException(CodeMsg.SERVER_ERROR);
        }
        Long mobile = loginUser.getMobile();
        String fromPass = loginUser.getPassword();
        SeckillUser users = getByMobile(mobile);
        if (users == null) {
            throw new GlobalException(CodeMsg.MOBILE_NOT_EXIST);
        }
        String dbPass = users.getPassword();
        String saltDb = users.getSalt();
        //获取加密之后的密码
        String calcPass = MD5Until.inputPassToDBPass(fromPass, saltDb);
        if (!calcPass.equals(dbPass)) {
            throw new GlobalException(CodeMsg.PASSWORD_ERROR);
        }
        //随机生成uuid
        String token = UUIDUntil.uuid();
        addCookie(response, token, users);
    }

    @Override
    public SeckillUser getByToken(HttpServletResponse response, String token) {
        if (StringUtils.isEmpty(token)) {
            return null;
        }
        SeckillUser user = redisservice.get(SeckillUserKey.token, token, SeckillUser.class);
        if (user != null) {
            //延长有效期
            addCookie(response, token, user);
        }
        return user;
    }


    @Override
    public void addCookie(HttpServletResponse response, String token, SeckillUser user) {
        //把信息放进redis
        redisservice.set(SeckillUserKey.token, token, user);
        //设置cookie
        Cookie cookie = new Cookie(COOKIE_NAME_TOKEN, token);
        cookie.setMaxAge(SeckillUserKey.token.expireSeconds());
        cookie.setPath("/");
        response.addCookie(cookie);
    }

}
