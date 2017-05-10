package com.wewills.base.sys.mapper;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.wewills.base.sys.model.SysPermission;

public interface SysPermissionMapper {

	public List<SysPermission> findMenuListByUserId(@Param("userId")String userId);

	public Set<String> findPercode(@Param("userId")String userId);
	
}
