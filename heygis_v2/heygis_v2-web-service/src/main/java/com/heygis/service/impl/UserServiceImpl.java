package com.heygis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.heygis.mapper.UserMapper;
import com.heygis.pojo.User;
import com.heygis.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<User> queryUserList(){
		return userMapper.queryUserList();
	}

}
