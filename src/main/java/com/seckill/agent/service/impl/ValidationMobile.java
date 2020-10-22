package com.seckill.agent.service.impl;

import com.alibaba.druid.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author lr-qixin
 * */
public class ValidationMobile {

	public static final Pattern MOBILE_PATTERN = Pattern.compile("1\\d{10}");

	public static boolean isMobile(String src) {
		if (StringUtils.isEmpty(src)) {
			return false;
		}
		Matcher m = MOBILE_PATTERN.matcher(src);
		return m.matches();
	}

}
