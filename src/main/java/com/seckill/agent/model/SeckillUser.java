package com.seckill.agent.model;

import com.seckill.agent.dto.resp.LoginRespDTO;

import javax.persistence.Table;
import java.util.Date;

/**
 * seckill_user
 * @author gaoFan
 */
@Table(name = "seckill_user")
public class SeckillUser extends LoginRespDTO {
    /**
     * 用户id
     */
    private Long id;

    /**
     * 手机号码
     */
    private Long mobile;

    private String nickname;

    /**
     * MD5(MD5(PASS明文+固定salt)+固定salt)
     */
    private String password;

    private String salt;

    /**
     * 头像，云存储的ID
     */
    private String head;

    /**
     * 注册时间
     */
    private Date registerDate;

    /**
     * 上次登录时间
     */
    private Date lastLoginDate;

    private Integer loginCount;

    private static final long serialVersionUID = 1L;
}