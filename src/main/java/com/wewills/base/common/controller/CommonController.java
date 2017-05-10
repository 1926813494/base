package com.wewills.base.common.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {

	@RequestMapping("/unauth")
	public String unauth(HttpServletResponse response) {
		response.setHeader("statusCode","403");
		return "error/unauth";
	}
	
	@RequestMapping("/unFound")
	public String unFound(HttpServletResponse response) {
		return "error/404";
	}
	
	@RequestMapping("/unknownError")
	public String unknownError(HttpServletResponse response) {
		return "error/500";		
	}
	
}
