package com.seckill.agent.service.impl;

import com.seckill.agent.dto.req.LoginUserDTO;
import com.seckill.agent.entity.LoginVo;
import com.seckill.agent.mapper.UserMapper;
import com.seckill.agent.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户服务
 *
 * @author qiXin
 * @date 2020/9/23
 **/
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserMapper usermapper;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public UserServiceImpl(UserMapper usermapper) {
        this.usermapper = usermapper;
    }

    @Override
    public LoginVo getById(Long mobile) {
        return usermapper.getById(mobile);
    }

    /**
     * 新增用户
     *
     * @param loginUserDTO 用户信息
     * @return 成功返回1
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertUser(LoginUserDTO loginUserDTO) {
        return usermapper.insertUser(loginUserDTO);
    }

}
