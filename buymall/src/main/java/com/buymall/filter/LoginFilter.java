package com.buymall.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.buymall.constants.Constants;
import com.buymall.entity.User;
import com.buymall.service.UserService;
import com.framework.core.spring.SpringContextHolder;
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
		
		User user = getSessionAndCookie(request);
		if(user == null){
			logger.info("Cookie不存在,跳转登录..");
			response.sendRedirect(Constants.config.getString("BASE_URL") + "/user/login?returnUrl=" + request.getRequestURL());
		}else {
			chain.doFilter(req, resp);
		}
	}
	/**
	 * 获取cookie和session
	 * @param request
	 * @return
	 */
	private User getSessionAndCookie(HttpServletRequest request){
		User user = (User) request.getSession().getAttribute("user");
		String userId = "";
		
		//先从session取数据
		if(request.getSession().getAttribute("user") != null){
			return user;
		}
		Cookie cookies[] = request.getCookies();
		
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(Constants.config.getString("COOKIE_DOMAIN"))) {
					userId = cookie.getValue();
					UserService userService = SpringContextHolder.getBean("userService");
					user = userService.findUserByUserId(userId);
					if(user != null){
						request.getSession().setAttribute("user", user);
					}
				}else {
					return null;
				}
			}
		} else {
			return null;
		}
		return user;
	}

	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
