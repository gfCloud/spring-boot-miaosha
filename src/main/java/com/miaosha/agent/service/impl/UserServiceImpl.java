package com.miaosha.agent.service.impl;

import com.miaosha.agent.entity.LoginVo;
import com.miaosha.agent.mapper.UserMapper;
import com.miaosha.agent.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

	private final UserMapper usermapper;

	@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
	public UserServiceImpl(UserMapper usermapper) {
		this.usermapper = usermapper;
	}


	@Override
	public LoginVo getByID(int id) {
		return usermapper.getbyID(id);
	}
	
	@Override
	@Transactional
	public int InsertUser (LoginVo user){
		int temp = 0;
		try{
			temp = usermapper.InsertUser(user);
		}catch(DuplicateKeyException de){
			System.out.println("主键冲突->DuplicateKeyException");
		}
		return temp;
	}

}
