package com.wewills.base.index.controller;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wewills.base.user.model.User;

import shiro.credential.PasswordHashedCredentialsMatcher;

@Controller //标识该类是一个Controller
public class IndexController {

	@Resource
	private PasswordHashedCredentialsMatcher passwordHashedCredentialsMatcher;
	
	@RequestMapping("/index")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("index");
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		mv.addObject("user", user);
		return mv;
	}
	
	@RequestMapping("/showmd5")
	@ResponseBody
	public String showMd5(String source) {
		String salt = "uiwueylm";
		String hashed = passwordHashedCredentialsMatcher.hashed(source, salt);
		return hashed;
	}
	
}
