package com.wewills.base.sys.service;

import java.util.List;
import java.util.Set;

import com.wewills.base.sys.model.SysPermission;

public interface SysService {

	public List<SysPermission> findMenuListByUserId(String userId);
	
	public Set<String> findPercode(String userId);
	
}
