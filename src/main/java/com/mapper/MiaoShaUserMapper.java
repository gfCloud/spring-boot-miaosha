package com.qixin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.qixin.entity.MiaoShaUser;

@Mapper
public interface MiaoShaUserMapper {

	public MiaoShaUser getbyID(@Param("id") String id);
	
}
