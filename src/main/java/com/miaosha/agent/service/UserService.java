package com.miaosha.agent.service;

import com.miaosha.agent.entity.LoginVo;
import com.miaosha.agent.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService  {

	@Autowired
	private UserMapper usermapper;

	public LoginVo getByID(int id) {
		return usermapper.getbyID(id);
	}
	
	@Transactional
	public int InsertUser (LoginVo user) throws Exception {
		int temp = 0;
		try{
			temp = usermapper.InsertUser(user);
		}catch(DuplicateKeyException de){
			System.out.println("主键冲突->DuplicateKeyException");
		}
		return temp;
	}

}
