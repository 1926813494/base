package com.wewills.base.role.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/role")
public class RoleController {

	@RequestMapping("/manage")
	@RequiresPermissions("role:manage")
	public String manage() {
		return "role";
	}
	
}
