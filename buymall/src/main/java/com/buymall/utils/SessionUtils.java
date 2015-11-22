package com.buymall.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;

import com.buymall.constants.Constants;
import com.buymall.entity.User;
import com.buymall.service.UserService;
import com.buymall.view.IndexController;
import com.framework.core.spring.SpringContextHolder;

public class SessionUtils {
	private static Logger logger = Logger.getLogger(SessionUtils.class);
	/**
	 * 获取cookie和session
	 * @param request
	 * @return
	 */
	public User getSessionAndCookie(HttpServletRequest request){
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
	
	public ModelAndView checkSession(HttpServletRequest request){
		User user = new SessionUtils().getSessionAndCookie(request);
		if(user == null){
			logger.info("Cookie不存在,跳转登录..");
			return new ModelAndView("redirect:/user/login?returnUrl=" + request.getRequestURL());
		}else {
			return null;
		}
		
	}
}
