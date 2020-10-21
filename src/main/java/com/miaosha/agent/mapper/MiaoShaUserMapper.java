package com.miaosha.agent.mapper;

import com.miaosha.agent.entity.MiaoShaUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author qixin
 *
 * */
@Mapper
public interface MiaoShaUserMapper {

	MiaoShaUser getByMobile(@Param("mobile") Long mobile);
	
}
