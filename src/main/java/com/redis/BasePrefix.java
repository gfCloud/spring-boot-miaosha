package com.qixin.redis;

public abstract class BasePrefix implements KeyPrefix {

	private int expireSeconds; // 过期时间

	private String prefix;   //名称
	
	public BasePrefix(String prefix) {
		this(0,prefix);
	}

	public BasePrefix(int expireSeconds, String prefix) {
		this.expireSeconds = expireSeconds;
		this.prefix = prefix;
	}

	@Override
	public int expireSeconds() { // 默认0永远不会过期
		return expireSeconds;
	}

	@Override
	public String getPrefix() {
		String clazz = getClass().getSimpleName(); // 获取类名
		return clazz + ":" + prefix;
	}

}
