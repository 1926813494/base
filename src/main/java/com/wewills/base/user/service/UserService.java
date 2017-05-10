package com.wewills.base.user.service;

import com.wewills.base.user.model.User;

public interface UserService {

	public void save(User user);
	
	public User getById(String id);
	
}
