package com.miaosha.agent.service.impl;

import com.alibaba.druid.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation_mobile {

	public static final Pattern mobile_pattern = Pattern.compile("1\\d{10}");

	public static boolean isMobile(String src) {
		if (StringUtils.isEmpty(src)) {
			return false;
		}
		Matcher m = mobile_pattern.matcher(src);
		return m.matches();
	}

}
