package com.wewills.base.common.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 * 全局异常类
 * </p>
 * 
 * @author 刘坤耀
 * @createTime 2017年5月10日 下午2:28:48
 */
public class GlobalException implements HandlerExceptionResolver {

	private static final Logger logger = LoggerFactory.getLogger(GlobalException.class);

	private String unauthorizedUrl;

	private String exceptionUrl;

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		ModelAndView mv = new ModelAndView();
		if (ex instanceof UnauthorizedException) {
			logger.debug(ex.getMessage());
			mv.setViewName("redirect:"+this.unauthorizedUrl);
			return mv;
		}
		ex.printStackTrace();
		mv.setViewName("redirect:"+this.exceptionUrl);
		return mv;
	}

	public void setUnauthorizedUrl(String unauthorizedUrl) {
		this.unauthorizedUrl = unauthorizedUrl;
	}

	public void setExceptionUrl(String exceptionUrl) {
		this.exceptionUrl = exceptionUrl;
	}

}
