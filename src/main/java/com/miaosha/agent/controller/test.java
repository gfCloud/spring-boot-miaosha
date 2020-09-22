package com.miaosha.agent.controller;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.boot.autoconfigure.jersey.JerseyProperties.Servlet;

public class test extends Servlet {

	public static void main(String[] args) {

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
		}, cal.getTime(), 24 * 60 * 60 * 1000);


		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				System.err.println("-------延迟5000毫秒，每1000毫秒执行一次--------");
			}
		}, 5000, 1000);

	}

}
