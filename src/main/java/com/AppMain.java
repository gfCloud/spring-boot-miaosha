package com.qixin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class AppMain {
	public static void main(String[] args) {
		  SpringApplication.run(AppMain.class,args);
		}
}
