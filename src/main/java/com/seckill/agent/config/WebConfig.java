package com.seckill.agent.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author qixin
 *
 * */
@Configuration
public class WebConfig implements WebMvcConfigurer {    //extends WebMvcConfigurerAdapter

	/**
	 * WebMvcConfigurer 包含 WebMvcConfigurerAdapter里面所有的方法
	 *
	 * */
	private final UserArgumentResolvers userArgumentResolvers;

	public WebConfig(UserArgumentResolvers userArgumentResolvers) {
		this.userArgumentResolvers = userArgumentResolvers;
	}

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(userArgumentResolvers);
	}
	

}
