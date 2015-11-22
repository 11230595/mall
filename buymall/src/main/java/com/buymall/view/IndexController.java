package com.buymall.view;

import java.util.Date;
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

import com.buymall.constants.Constants;
import com.buymall.entity.Banner;
import com.buymall.entity.LoginLog;
import com.buymall.entity.PlatformActivity;
import com.buymall.entity.Product;
import com.buymall.entity.User;
import com.buymall.service.BannerService;
import com.buymall.service.LoginLogService;
import com.buymall.service.PlatformActivityService;
import com.buymall.service.ProductService;
import com.buymall.service.UserService;
import com.buymall.utils.SessionUtils;
import com.framework.core.page.Page;
import com.framework.core.utils.DateUtils;
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
	@Resource
	private PlatformActivityService platformActivityService;
	/**
	 * 首页
	 * @return
	 */
	@RequestMapping(value="index/{pageNo}",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView index(HttpServletRequest request,@PathVariable int pageNo,
			@RequestParam(required=false) String type,
			@RequestParam(required=false) String userType,
			@RequestParam(required=false) String keyword) {
		ModelAndView mav = new ModelAndView("index");
		//从cookie取数据
		User user = new SessionUtils().getSessionAndCookie(request);
		if(user != null){
			loginLogService.insert(new LoginLog(LoginLog.APP_NAME, 10, user.getUserCode(), "", "", ""));
		}
		
		//头部信息
		Page<Banner> bannerPage = findBanner(0);
		//中部信息
		Page<Banner> bPage	= findBanner(2);
		
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
		if(StringUtils.isNotBlank(keyword)){
			map.put("keyword", keyword);
			mav.addObject("keyword", keyword);
		}
		
		map.put("expireTime", DateUtils.DateToString(new Date(),"yyyy-MM-dd HH:mm:ss"));
		int pageSize = 21;
		Page<Product> page = productService.findByPage(map, pageNo, pageSize);
		
		mav.addObject("bannerPage", bannerPage);
		mav.addObject("bPage", bPage); 
		mav.addObject("page", page);
		mav.addObject("url",Constants.config.getString("BASE_URL"));
		mav.addObject("mobileUrl",Constants.config.getString("MOBILE_URL"));
		return mav;
	}
	
	/**
	 * 查询海报
	 * @param bannerType 
	 * @return
	 */
	private Page<Banner> findBanner(int bannerType) {
		return bannerService.findByPage(bannerType);
	}

	/**
	 * 关于
	 * @return
	 */
	@RequestMapping(value="about",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView about() {
		return new ModelAndView("about","url",Constants.config.getString("BASE_URL"));
	}
	
	/**
	 * 关于
	 * @return
	 */
	@RequestMapping(value="help",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView help() {
		return new ModelAndView("help","url",Constants.config.getString("BASE_URL"));
	}
}
