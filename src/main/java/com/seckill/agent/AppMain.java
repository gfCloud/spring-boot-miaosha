package com.seckill.agent;

import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
@MapperScan(basePackages = {"com.seckill.agent.mapper"})
public class AppMain {
	public static void main(String[] args) {
		  SpringApplication.run(AppMain.class,args);
		}
}
