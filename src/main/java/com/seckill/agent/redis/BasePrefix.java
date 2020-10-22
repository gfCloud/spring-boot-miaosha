package com.seckill.agent.redis;

/**
 * @author lr-qixin
 *
 * */
public abstract class BasePrefix implements KeyPrefix {
	/**
	 * expireSeconds 过期时间
	 * */
	private int expireSeconds;
	/**
	 * prefix 名称
	 * */
	private String prefix;
	public BasePrefix(String prefix) {
		this(0,prefix);
	}

	public BasePrefix(int expireSeconds, String prefix) {
		this.expireSeconds = expireSeconds;
		this.prefix = prefix;
	}

	@Override
	public int expireSeconds() {
		return expireSeconds;
	}

	@Override
	public String getPrefix() {
		// 获取类名
		String clazz = getClass().getSimpleName();
		return clazz + ":" + prefix;
	}

}
