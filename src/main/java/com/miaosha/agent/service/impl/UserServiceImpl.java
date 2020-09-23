package com.miaosha.agent.service.impl;

import com.miaosha.agent.entity.LoginVo;
import com.miaosha.agent.mapper.UserMapper;
import com.miaosha.agent.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

	private final UserMapper usermapper;

	@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
	public UserServiceImpl(UserMapper usermapper) {
		this.usermapper = usermapper;
	}


	@Override
	public LoginVo getById(int id) {
		return usermapper.getbyID(id);
	}

	/**
	 * 新增用户
	 *
	 * @param user 用户信息
	 * @return 成功返回1
	 */
	@Override
	@Transactional(rollbackFor = DuplicateKeyException.class)
	public int insertUser(LoginVo user) {
		int temp;
		try {
			temp = usermapper.InsertUser(user);
		} catch (DuplicateKeyException de) {
			throw de;
		}
		return temp;
	}

}
