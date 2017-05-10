package com.wewills.base.user.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wewills.base.user.model.User;
import com.wewills.base.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private UserService userService;
	
	@RequestMapping("/page")
	public String page() {
		return "user";
	}
	
	@RequestMapping("/datas")
	@ResponseBody
	public Map<String, Object> datas() {
		Map<String, Object> map = new HashMap<>();
		map.put("name", "测试");
		map.put("time", new Date());
		return map;
	}
	
	@RequestMapping("/create")
	@ResponseBody
	public Map<String, Object> create(String name) {
		User user = new User();
		userService.save(user);
		Map<String, Object> map = new HashMap<>();
		map.put("user", user);
		return map;
	}
	
	
}
