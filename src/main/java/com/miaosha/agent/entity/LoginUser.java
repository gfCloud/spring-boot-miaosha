package com.miaosha.agent.entity;

import lombok.Data;

@Data
public class LoginUser {

	private String id;
	private String password;

	@Override
	public String toString() {
		return "login [mobile=" + id + ", password=" + password + "]";
	}

}
