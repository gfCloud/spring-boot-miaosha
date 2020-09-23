package com.miaosha.agent;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
@MapperScan(basePackages = {"com.miaosha.agent.mapper"})
public class AppMain {
	public static void main(String[] args) {
		  SpringApplication.run(AppMain.class,args);
		}
}
