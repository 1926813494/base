package com.wewills.base.login.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(HttpServletRequest request) {
		String tips = "";
		String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
		logger.info("login--->"+exceptionClassName);
		if(exceptionClassName != null) {
			if(UnknownAccountException.class.getName().equals(exceptionClassName)) {
				tips = "账号不存在";
			}else if(IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
				tips = "账号或密码不正确";
			}else if(LockedAccountException.class.getName().equals(exceptionClassName)) {
				tips = "账户被锁定";
			}else if("randomCodeError".equals(exceptionClassName)) {
				tips = "验证码错误";
			}else {
				tips = "登录失败";
			}
		}
		request.setAttribute("tips", tips);
		return "login";
	}
	
}
