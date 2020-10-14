package com.miaosha.agent.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	@Autowired
	UserArgumentResolvers userArgumentResolvers;

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(userArgumentResolvers);
	}
	

}
