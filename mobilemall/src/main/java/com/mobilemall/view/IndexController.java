package com.mobilemall.view;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.framework.core.page.Page;
import com.framework.core.utils.IPUtils;
import com.mobilemall.constants.Constants;
import com.mobilemall.entity.Banner;
import com.mobilemall.entity.LoginLog;
import com.mobilemall.entity.Product;
import com.mobilemall.entity.User;
import com.mobilemall.service.BannerService;
import com.mobilemall.service.LoginLogService;
import com.mobilemall.service.ProductService;
import com.mobilemall.service.UserService;
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
	@RequestMapping(value="index/{pageNo}",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView index(HttpServletRequest request,@PathVariable int pageNo,
			@RequestParam(required=false) String type,@RequestParam(required=false) String userType) {
		ModelAndView mav = new ModelAndView("index");
		//从cookie取数据
		User user = getSessionAndCookie(request);
		if(user != null){
			loginLogService.insert(new LoginLog(LoginLog.APP_NAME, 10, user.getUserCode(), "", "", ""));
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		//分页查询产品
		if(StringUtils.isNotBlank(type)){
			map.put("type", Integer.parseInt(type));
			mav.addObject("type", type);
		}
		if(StringUtils.isNotBlank(userType)){
			map.put("userType", Integer.parseInt(userType));
			mav.addObject("userType", userType);
		}
		Page<Product> page = productService.findByPage(map, pageNo, 21);
		
		mav.addObject("page", page);
		mav.addObject("url",Constants.config.getString("BASE_URL"));
		mav.addObject("pc_url",Constants.config.getString("PC_URL"));
		return mav;
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
}
