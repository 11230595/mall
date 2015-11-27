package com.buymall.view;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.buymall.constants.Constants;
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
		return new ModelAndView("admin/index","url",Constants.config.getString("BASE_URL"));
	}
	
	/**
	 * 京东导入产品
	 * @return
	 */
	@RequestMapping(value="admin/jd",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView jd(HttpServletRequest request) {
		return new ModelAndView("admin/jd_add","url",Constants.config.getString("BASE_URL"));
	}

	/**
	 * 淘宝客活动导入产品
	 * @return
	 */
	@RequestMapping(value="admin/99",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView tkactivity(HttpServletRequest request) {
		return new ModelAndView("admin/99_add","url",Constants.config.getString("BASE_URL"));
	}

	
	/**
	 * 专区产品导入
	 * @return
	 */
	@RequestMapping(value="admin/link",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView link(HttpServletRequest request) {
		return new ModelAndView("admin/link_add","url",Constants.config.getString("BASE_URL"));
	}
	
	
}
