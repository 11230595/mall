package com.buymall.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.buymall.constants.Constants;
import com.buymall.entity.User;
import com.buymall.utils.SessionUtils;
/**
 * 判断是否登录
 * @author zhoudong
 *
 */
public class LoginFilter implements Filter{
	private static Logger logger = Logger.getLogger(LoginFilter.class);
	public void destroy() {
		
	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse)resp;
		
		User user = new SessionUtils().getSessionAndCookie(request);
		if(user == null){
			logger.info("Cookie不存在,跳转登录..");
			response.sendRedirect(Constants.config.getString("BASE_URL") + "/user/login?returnUrl=" + request.getRequestURL());
		}else {
			chain.doFilter(req, resp);
		}
	}
	

	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
