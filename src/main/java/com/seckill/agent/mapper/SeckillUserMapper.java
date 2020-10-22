package com.seckill.agent.mapper;

import com.seckill.agent.entity.SeckillUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author qixin
 *
 * */
@Mapper
public interface SeckillUserMapper {

	/**
	 * getByMobile
	 * @param  mobile 手机号
	 * @return    秒杀用户信息
	 * */
	SeckillUser getByMobile(@Param("mobile") Long mobile);
	
}
