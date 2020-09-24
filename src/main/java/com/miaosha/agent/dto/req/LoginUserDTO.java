package com.miaosha.agent.dto.req;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 用户登录信息
 *
 * @author gaoFan
 * @version V1.0
 * @date 2020/9/24 16:49
 */

@Data
public class LoginUserDTO {

    @NotBlank(message = "ID不能为空")
    private Integer id;

    @NotBlank(message = "用户名不能为空")
    private String name;
}
