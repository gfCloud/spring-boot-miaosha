package com.miaosha.agent.service;

import com.miaosha.agent.entity.LoginVo;

public interface UserService {

     LoginVo getByID(int id);

     int InsertUser (LoginVo user);

}
