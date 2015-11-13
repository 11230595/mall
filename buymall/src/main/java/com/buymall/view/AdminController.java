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
/**
 * 后台管理部分
 * @author zhoudong
 *
 */
@Controller
public class AdminController {
	private static Logger logger = Logger.getLogger(AdminController.class);
	
	/**
	 * 后台首页
	 * @return
	 */
	@RequestMapping(value="admin",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView index(HttpServletRequest request) {
		return new ModelAndView("admin/index");
	}
}
