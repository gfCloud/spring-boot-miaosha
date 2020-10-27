package com.seckill.agent.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * seckill_user
 * @author gaoFan
 */
@Table(name = "seckill_user")
public class SeckillUser{
    /**
     * 用户id
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 手机号码
     */
    @Column(name = "mobile")
    private String mobile;

    @Column(name = "nickname")
    private String nickname;

    /**
     * MD5(MD5(PASS明文+固定salt)+固定salt)
     */
    @Column(name = "password")
    private String password;

    @Column(name = "salt")
    private String salt;

    /**
     * 头像，云存储的ID
     */
    @Column(name = "head")
    private String head;

    /**z
     * 注册时间
     */
    @Column(name = "register_date")
    private Date registerDate;

    /**
     * 上次登录时间
     */
    @Column(name = "last_login_date")
    private Date lastLoginDate;

    @Column(name = "login_count")
    private Integer loginCount;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public Integer getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}