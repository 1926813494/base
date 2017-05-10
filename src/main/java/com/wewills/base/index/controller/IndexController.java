package com.wewills.base.index.controller;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wewills.base.user.model.User;

@Controller //标识该类是一个Controller
public class IndexController {

	@RequestMapping("/index")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("index");
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		mv.addObject("user", user);
		return mv;
	}
	
}
