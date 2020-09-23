package com.miaosha.agent.mapper;

import com.miaosha.agent.entity.MiaoShaUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MiaoShaUserMapper {

	MiaoShaUser getbyID(@Param("id") String id);
	
}
