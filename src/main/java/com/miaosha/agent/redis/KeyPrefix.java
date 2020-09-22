package com.miaosha.agent.redis;

public interface KeyPrefix {
	
	public int expireSeconds();
	
	public String getPrefix();
	
}
