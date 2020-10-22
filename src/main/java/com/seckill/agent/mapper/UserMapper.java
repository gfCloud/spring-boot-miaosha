package com.seckill.agent.mapper;

import com.seckill.agent.common.mapper.MyMapper;
import com.seckill.agent.dto.req.LoginUserDTO;
import com.seckill.agent.model.SeckillUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author qixin
 */
@Mapper
public interface UserMapper extends MyMapper<SeckillUser> {

    /**
     * getById
     * @param mobile 手机号
     * @return 用户
     */
//    LoginRespDTO getById(@Param("mobile") long mobile);

    /**
     * InsertUser
     * @param loginUserDTO 用户
     * @return int
     */
    int insertUser(LoginUserDTO loginUserDTO);

}
