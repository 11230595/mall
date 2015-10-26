package com.buymall.view;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.buymall.constants.Constants;
import com.buymall.entity.LoginLog;
import com.buymall.entity.User;
import com.buymall.service.LoginLogService;
import com.buymall.service.UserService;
import com.framework.core.utils.IPUtils;
/**
 * 首页部分功能
 * @author zhoudong
 *
 */
@Controller
public class IndexController {
	private static Logger logger = Logger.getLogger(IndexController.class);
	@Resource
	private UserService userService;
	@Resource
	private LoginLogService loginLogService;
	
	/**
	 * 首页
	 * @return
	 */
	@RequestMapping(value="index",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView index(HttpServletRequest request) {
		//从cookie取数据
		String ip = IPUtils.getIP(request);
		
		User user = getSessionAndCookie(request);
		if(user != null){
			loginLogService.insert(new LoginLog(LoginLog.APP_NAME, 10, user.getUserCode(), "", ip, IPUtils.getAddress(ip)));
		}
		return new ModelAndView("index","style","navbar navbar-inverse navbar-static-top");
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
	
	
	/**
	 * 关于
	 * @return
	 */
	@RequestMapping(value="about",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView about() {
		return new ModelAndView("about","url",Constants.config.getString("BASE_URL"));
	}
}
