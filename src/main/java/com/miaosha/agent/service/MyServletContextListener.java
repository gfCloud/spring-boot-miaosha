package com.miaosha.agent.service;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener 
public class MyServletContextListener implements ServletContextListener {
	
	
	public MyServletContextListener() {
		System.out.println("监听器启动");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		 System.out.println("context销毁了");
	}

	
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		 System.out.println("context创建了....");
		 Calendar cal = Calendar.getInstance();
			// 每天定bai点du执行zhi
			cal.set(Calendar.HOUR_OF_DAY, 12);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			Timer timer = new Timer();
			timer.schedule(new TimerTask() {
				public void run() {
					System.out.println("定时器测试！");
				}
			}, cal.getTime(),  24 * 60 * 60 *1000);   //
		
		
	}
	
	

}
