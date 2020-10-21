package com.miaosha.agent.mapper;

import com.miaosha.agent.dto.req.LoginUserDTO;
import com.miaosha.agent.entity.LoginVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author qixin
 *
 */
@Mapper
public interface UserMapper {

    LoginVo getById(@Param("mobile") long mobile);

    int InsertUser(LoginUserDTO loginUserDTO);

}
