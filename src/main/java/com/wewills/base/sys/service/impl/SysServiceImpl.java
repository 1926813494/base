package com.wewills.base.sys.service.impl;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wewills.base.sys.mapper.SysPermissionMapper;
import com.wewills.base.sys.model.SysPermission;
import com.wewills.base.sys.service.SysService;

@Service
public class SysServiceImpl implements SysService {
	
	@Resource
	private SysPermissionMapper sysPermissionMapper;

	public List<SysPermission> findMenuListByUserId(String userId) {
		return sysPermissionMapper.findMenuListByUserId(userId);
	}

	public Set<String> findPercode(String userId) {
		return sysPermissionMapper.findPercode(userId);
	}
}
