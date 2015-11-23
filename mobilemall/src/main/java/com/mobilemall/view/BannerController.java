package com.mobilemall.view;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.framework.core.utils.IDUtils;
import com.mobilemall.entity.Banner;
import com.mobilemall.service.BannerService;
/**
 * 产品类
 * @author zhoudong
 *
 */
@Controller
@RequestMapping("banner")
public class BannerController {
	private static Logger logger = Logger.getLogger(BannerController.class);
	@Resource
	private BannerService bannerService;
	/**
	 * 保存banner
	 * @return
	 */
	@RequestMapping(value="add",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Map<String, Object> saveBanner(HttpServletRequest request,Banner banner) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			banner.setId(IDUtils.getId());
			bannerService.insert(banner);
			map.put("respCode", 0);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("respCode", 1);
		}
		return map;
	}
	
	/**
	 * 查询全部banner
	 * @return
	 */
	@RequestMapping(value="findAll",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Map<String, Object> findAllBanner(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Banner> list = bannerService.findAll();
		map.put("banners", list);
		return map;
	}
	
	/**
	 * 删除banner
	 * @return
	 */
	@RequestMapping(value="del/{id}",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Map<String, Object> deleteBanner(HttpServletRequest request,@PathVariable String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			bannerService.deleteByPrimaryKey(id);
			map.put("respCode", 0);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("respCode", 1);
		}
		return map;
	}
}
