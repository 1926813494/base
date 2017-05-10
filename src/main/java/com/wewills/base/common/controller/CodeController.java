package com.wewills.base.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CodeController {
	
	@RequestMapping(value="/code.jpg",method=RequestMethod.GET)
	public String code() {
		return "validatecode";
	}
	
}
