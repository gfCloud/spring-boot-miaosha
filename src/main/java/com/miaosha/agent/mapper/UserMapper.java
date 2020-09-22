package com.miaosha.agent.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.miaosha.agent.entity.LoginVo;

@Mapper
public interface UserMapper {

	LoginVo getbyID(@Param("id") int id);
	
	int InsertUser(LoginVo user);

}
