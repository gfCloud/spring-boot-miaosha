package com.seckill.agent.redis;

/***
 * @author lr-qixin
 *
 */

public interface KeyPrefix {
	/**
	 * expireSeconds 过期时间
	 * @return int
	 */
	 int expireSeconds();
	/**
	 * getPrefix 名称
	 * @return 名称
	 */
	 String getPrefix();
	
}
