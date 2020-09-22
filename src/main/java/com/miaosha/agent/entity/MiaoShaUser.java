package com.miaosha.agent.entity;

import java.util.Date;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import com.miaosha.agent.validator.IsMobile;

public class MiaoShaUser {
	@NotNull
	@IsMobile
	private String id;
	private String nickname;
	@NotNull
	@Length(min=6)
	private String password;
	private String salt;
	private String head;
	private Date registerdate;
	private Date lastlogindate;
	private Integer logincount;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public Date getRegisterdate() {
		return registerdate;
	}

	public void setRegisterdate(Date registerdate) {
		this.registerdate = registerdate;
	}

	public Date getLastlogindate() {
		return lastlogindate;
	}

	public void setLastlogindate(Date lastlogindate) {
		this.lastlogindate = lastlogindate;
	}

	public Integer getLogincount() {
		return logincount;
	}

	public void setLogincount(Integer logincount) {
		this.logincount = logincount;
	}

	@Override
	public String toString() {
		return "miaoShaUser [id=" + id + ", nickname=" + nickname + ", password=" + password + ", salt=" + salt
				+ ", head=" + head + ", register_date=" + registerdate + ", last_login_date=" + lastlogindate
				+ ", login_count=" + logincount + "]";
	}

}
