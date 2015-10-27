package com.buymall.view;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.buymall.constants.Constants;
import com.buymall.entity.Banner;
import com.buymall.entity.LoginLog;
import com.buymall.entity.Product;
import com.buymall.entity.User;
import com.buymall.service.BannerService;
import com.buymall.service.LoginLogService;
import com.buymall.service.ProductService;
import com.buymall.service.UserService;
import com.framework.core.page.Page;
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
	@Resource
	private ProductService productService;
	@Resource
	private BannerService bannerService;
	
	/**
	 * 首页
	 * @return
	 */
	@RequestMapping(value="index",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView index(HttpServletRequest request) {
		//String ip = IPUtils.getIP(request);
		//从cookie取数据
		User user = getSessionAndCookie(request);
		if(user != null){
			loginLogService.insert(new LoginLog(LoginLog.APP_NAME, 10, user.getUserCode(), "", "", ""));
		}
		
		//头部信息
		Page<Banner> bannerPage = findBanner();
		
		//分页查询产品
		Page<Product> page = productService.findByPage(new HashMap<String, Object>(), 1, 10);
		
		return new ModelAndView("index");
	}
	
	/**
	 * 查询海报
	 * @return
	 */
	private Page<Banner> findBanner() {
		return bannerService.findByPage();
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
