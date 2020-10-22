package com.seckill.agent.service.impl;

import com.seckill.agent.common.service.impl.CommonServiceImpl;
import com.seckill.agent.dto.req.LoginUserDTO;
import com.seckill.agent.dto.resp.LoginRespDTO;
import com.seckill.agent.mapper.UserMapper;
import com.seckill.agent.model.SeckillUser;
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
public class UserServiceImpl extends CommonServiceImpl<SeckillUser, Long> implements UserService {

    private final UserMapper usermapper;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public UserServiceImpl(UserMapper usermapper) {
        this.usermapper = usermapper;
    }

    @Override
    public LoginRespDTO getById(Long mobile) {
        return usermapper.selectByPrimaryKey(mobile);
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
