package com.seckill.agent.dto.resp;

import lombok.Data;

/**
 * 用户返回实体
 *
 * @author gaoFan
 * @version V1.0
 * @date 2020/10/22 17:57
 */

@Data
public class LoginRespDTO {

    private String mobile;
    private String name;
    private String password;
    private String salt;

}
