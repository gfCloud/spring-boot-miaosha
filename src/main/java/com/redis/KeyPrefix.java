package com.qixin.redis;

public interface KeyPrefix {
	
	public int expireSeconds();
	
	public String getPrefix();
	
}
