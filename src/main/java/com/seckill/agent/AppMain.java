package com.seckill.agent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author flysg
 */
@SpringBootApplication
@ServletComponentScan
@MapperScan(basePackages = {"com.seckill.agent.mapper","com.seckill.agent.common.mapper"})
public class AppMain {
	public static void main(String[] args) {
		  SpringApplication.run(AppMain.class,args);
		}
}
