package shiro.filter; 

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

public class BaseFormAuthenticationFilter extends FormAuthenticationFilter {

	//原FormAuthenticationFilter的认证方法
	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		//进行验证码认证
		String randomcode = httpRequest.getParameter("randomcode");		
		if(randomcode != null && !randomcode.trim().equals("")) {
			String validateCode = (String) httpRequest.getSession().getAttribute("validateCode");
			if(randomcode.equals(validateCode)) {
				return super.onAccessDenied(request, response);
			}			
		}
		httpRequest.setAttribute("shiroLoginFailure", "randomCodeError");
		return true;
	}

}
