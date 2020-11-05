package com.seckill.agent.controller;

import org.springframework.boot.autoconfigure.jersey.JerseyProperties.Servlet;

import java.text.ParseException;

public class test extends Servlet {

	public static void main(String[] args) throws ParseException {
		String secret = "puY0ExuOi86swFwD";
		String appId = "83345470-0fef-4e43-9a0f-8f76e3806275";
		String token = java.util.Base64.getEncoder().encodeToString((appId + ":" + secret).getBytes());
		System.out.println("token = " + token);
	}

}
