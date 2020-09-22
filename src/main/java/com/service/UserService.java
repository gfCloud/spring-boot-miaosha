package com.qixin.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qixin.entity.LoginVo;
import com.qixin.mapper.UserMapper;

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
