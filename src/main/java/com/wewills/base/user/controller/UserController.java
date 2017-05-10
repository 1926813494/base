package com.wewills.base.user.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wewills.base.user.model.User;
import com.wewills.base.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private UserService userService;
	
	@RequestMapping("/manage")
	@RequiresPermissions("user:manage")
	public ModelAndView manage() {
		ModelAndView mv = new ModelAndView("user");
		List<User> users = userService.findAll();
		mv.addObject("users", users);
		return mv;
	}
	
	@RequestMapping("/create")
	@RequiresPermissions("user:create")
	@ResponseBody
	public String create() {
		return "create";
	}
	
}
