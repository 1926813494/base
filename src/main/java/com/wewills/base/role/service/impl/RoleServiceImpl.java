package com.wewills.base.role.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wewills.base.role.mapper.RoleMapper;
import com.wewills.base.role.model.Role;
import com.wewills.base.role.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Resource
	private RoleMapper roleMapper;
	
	public List<Role> findPage() {
		return roleMapper.findPage();
	}

}
