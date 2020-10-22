package com.seckill.agent.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class RedisService {

	@Autowired
	JedisPool jedispool;

	
	/**
	 * 获取单个对象
	 * */
	public <T> T get(KeyPrefix keyPrefix, String key, Class<T> clazz) {
		Jedis jedis = null;
		try {
			jedis = jedispool.getResource();
			// 拼接
			String relkey = keyPrefix.getPrefix() + key;
			String str = jedis.get(relkey);
			T t = stringToBean(str, clazz);
			return t;
		} finally {
			returnToPool(jedis);
		}
	}

	/**
	 * 设置对象
	 **/
	public <T> Boolean set(KeyPrefix keyPrefix, String key, T value) {
		Jedis jedis = null;
		try {
			jedis = jedispool.getResource();
			String str = beanToString(value);
			if (str == null || str.length() <= 0) {
				return false;
			}
			String realkey = keyPrefix.getPrefix() + key;
			int seconds = keyPrefix.expireSeconds();
			if(seconds <= 0){
				jedis.set(realkey, str);   //不设置过期时间 永不过期
			}else{
				jedis.setex(realkey, seconds, str);   //设置过期时间
			}
			
			return true;
		} finally {
			returnToPool(jedis);
		} 
	}
	
	//判断key是否存在
	public <T> Boolean exists(KeyPrefix keyPrefix, String key) {
		Jedis jedis = null;
		try {
			jedis = jedispool.getResource();
			String realkey = keyPrefix.getPrefix() + key;
			return jedis.exists(realkey);   //判断一个key是否存在
		} finally {
			returnToPool(jedis);
		} 
	}
	
	//增加值   123 -》 124
	public <T> Long incr(KeyPrefix keyPrefix, String key) {
		Jedis jedis = null;
		try {
			jedis = jedispool.getResource();
			String realkey = keyPrefix.getPrefix() + key;
			return jedis.incr(realkey);   //增加
		} finally {
			returnToPool(jedis);
		} 
	}
	
	//减少值   123 -》 122
	public <T> Long decr(KeyPrefix keyPrefix, String key) {
		Jedis jedis = null;
		try {
			jedis = jedispool.getResource();
			String realkey = keyPrefix.getPrefix() + key;
			return jedis.decr(realkey);   //减少
		} finally {
			returnToPool(jedis);
		} 
	}
   
	// String转换成bean
	@SuppressWarnings("unchecked")
	private <T> T stringToBean(String str, Class<T> clazz) {
		if (str == null || str.length() <= 0 || clazz == null) {
			return null;
		}
		if (clazz == Integer.class || clazz == int.class) {
			return (T) Integer.valueOf(str);
		} else if (clazz == long.class || clazz == Long.class) {
			return (T) Long.valueOf(str);
		} else if (clazz == String.class) {
			return (T) str;
		} else {
			return JSON.toJavaObject(JSON.parseObject(str), clazz);
		}
	}

	// bean转换成String
	private <T> String beanToString(T value) {
		if (value == null) {
			return null;
		}
		Class<?> clazz = value.getClass();
		if (clazz == Integer.class || clazz == int.class) {
			return "" + value;
		} else if (clazz == long.class || clazz == Long.class) {
			return "" + value;
		} else if (clazz == String.class) {
			return (String) value;
		} else {
			return JSON.toJSONString(value);
		}
	}

	private void returnToPool(Jedis jedis) {
		if (jedis != null) {
			jedis.close();
		}
	}

}
