package com.wewills.base.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wewills.base.user.mapper.UserMapper;
import com.wewills.base.user.model.User;
import com.wewills.base.user.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserMapper userMapper;
	
	@Override
	public void save(User user) {
		userMapper.save(user);
	}

	@Override
	public User getById(String id) {
		return userMapper.getById(id);
	}

	@Override
	public List<User> findAll() {
		return userMapper.findAll();
	}

}
