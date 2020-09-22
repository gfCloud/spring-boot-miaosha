package com.qixin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.qixin.entity.LoginVo;

@Mapper
public interface UserMapper {

	LoginVo getbyID(@Param("id") int id);
	
	int InsertUser(LoginVo user);

}
