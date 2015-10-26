package com.buymall.view;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.buymall.entity.LoginLog;
import com.buymall.entity.User;
import com.buymall.service.LoginLogService;
import com.buymall.service.UserService;
import com.framework.core.utils.IPUtils;

@Controller
public class AdminController {
	private static Logger logger = Logger.getLogger(AdminController.class);
	@Resource
	private UserService userService;
	@Resource
	private LoginLogService loginLogService;
	
	/**
	 * 首页
	 * @return
	 */
	@RequestMapping(value="admin",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView index(HttpServletRequest request) {
		//从cookie取数据
		String ip = IPUtils.getIP(request);
		
		User user = getSessionAndCookie(request);
		
		if(user == null){
			logger.info("Cookie不存在,跳转登录..");
			redirect: return new ModelAndView("redirect:/user/login?returnUrl=../admin");
		}
		loginLogService.insert(new LoginLog(LoginLog.APP_NAME, 10, user.getUserCode(), "", ip, IPUtils.getAddress(ip)));
		return new ModelAndView("admin/index");
	}
	
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
				if (cookie.getName().equals("dovip_user")) {
					userId = cookie.getValue();
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
}
