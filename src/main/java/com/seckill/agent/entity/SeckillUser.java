package com.seckill.agent.entity;

import com.seckill.agent.validator.IsMobile;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@Table(name = "seckill_user")
public class SeckillUser {
    private Integer id;
    @NotBlank(message = "手机号不能为空")
    @IsMobile
    private Long mobile;
    private String nickname;
    @NotBlank(message = "密码不能为空")
    @Length(min = 6, message = "密码长度错误")
    private String password;
    private String salt;
    private String head;
    private Date registerdate;
    private Date lastlogindate;
    private Integer logincount;
}