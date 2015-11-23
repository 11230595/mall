package com.buymall.manager;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.buymall.entity.User;

public interface SessionManager {
	/**
	 * 获取session和cookie
	 * @param request
	 * @return
	 */
	User getSessionAndCookie(HttpServletRequest request);
	/**
	 * 检查session是否存在
	 * @param request
	 * @return
	 */
	ModelAndView checkSession(HttpServletRequest request);
}
