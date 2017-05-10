package com.wewills.base.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <p>登录Controller</p>
 * @author 刘坤耀
 * @createTime 2017年5月10日 上午9:04:54
 */
@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	/**
	 * 跳转到登录页面
	 * @author 刘坤耀
	 * @createTime 2017年5月10日 上午9:05:13
	 * @return
	 */
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(HttpServletResponse response) {
		//判断已经登录就不需要跳转到登录页面
		Subject subject = SecurityUtils.getSubject();
		Object principal = subject.getPrincipal();
		if(principal != null) {
			return "redirect:index";
		}
		response.setHeader("statusCode", "401");
		return "login";
	}
	
	/**
	 * 登录请求验证
	 * @author 刘坤耀
	 * @createTime 2017年5月10日 上午9:05:34
	 * @param request
	 * @return
	 */
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
