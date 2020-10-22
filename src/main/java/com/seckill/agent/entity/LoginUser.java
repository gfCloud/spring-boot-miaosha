package com.seckill.agent.entity;

import lombok.Data;

@Data
public class LoginUser {

	private Integer id;
	private Long mobile;
	private String password;

	@Override
	public String toString() {
		return "login [mobile=" + mobile + ", password=" + password + "]";
	}

}
