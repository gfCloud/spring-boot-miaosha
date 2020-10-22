package com.seckill.agent.service;

import com.seckill.agent.common.service.ICommonService;
import com.seckill.agent.dto.req.LoginUserDTO;
import com.seckill.agent.dto.resp.LoginRespDTO;
import com.seckill.agent.model.SeckillUser;

/**
 * 用户
 *
 * @author qiXin
 * @date 2020/9/23
 **/
public interface UserService extends ICommonService<SeckillUser, Long> {

    /**
     * 根据ID获取信息
     *
     * @param mobile 用户手机
     * @return 用户信息
     */
    LoginRespDTO getById(Long mobile);

    /**
     * 新增用户信息
     *
     * @param loginUserDTO 用户信息
     * @return 成功返回1
     */
    int insertUser(LoginUserDTO loginUserDTO);

}
