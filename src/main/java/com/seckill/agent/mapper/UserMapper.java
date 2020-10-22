package com.seckill.agent.mapper;

import com.seckill.agent.entity.LoginVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author qixin
 */
@Mapper
public interface UserMapper {

    /**
     * getById
     * @param mobile 手机号
     * @return 用户
     */
    LoginVo getById(@Param("mobile") long mobile);

}
