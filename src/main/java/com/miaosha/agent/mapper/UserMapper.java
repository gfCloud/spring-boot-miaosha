package com.miaosha.agent.mapper;

import com.miaosha.agent.entity.LoginVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

	LoginVo getbyID(@Param("id") int id);
	
	int InsertUser(LoginVo user);

}
