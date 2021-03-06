package com.wewills.base.user.mapper;

import java.util.List;

import com.wewills.base.user.model.User;

public interface UserMapper {

	public void save(User user);
	
	public User getById(String id);
	
	public List<User> findAll();
	
}
