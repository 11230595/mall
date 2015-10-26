package com.buymall.view;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buymall.entity.Product;
import com.buymall.entity.User;
import com.buymall.service.LoginLogService;
import com.buymall.service.ProductService;
import com.buymall.service.UserService;
import com.buymall.utils.GetProduct;
import com.framework.core.page.Page;
import com.framework.core.utils.DateUtils;

@Controller
@RequestMapping("product")
public class ProductController {
	private static Logger logger = Logger.getLogger(ProductController.class);
	@Resource
	private UserService userService;
	@Resource
	private LoginLogService loginLogService;
	@Resource
	private ProductService productService;
	
	/**
	 * 保存商品
	 * @return
	 */
	@RequestMapping(value="add",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Map<String, Object> saveProduct(HttpServletRequest request,@RequestParam String url, @RequestParam String type) {
		Map<String, Object> map = GetProduct.autoSaveAiTaoBao(url);
		Product product = new Product();
		try {
			BeanUtils.populate(product, map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		product.setId(UUID.randomUUID().toString());
		product.setType(Integer.parseInt(type));
		product.setStatus(0);
		product.setExpireTime(DateUtils.addDay(new Date(), 3));
		product.setScore(String.valueOf(map.get("scoreCount")));
		
		try {
			productService.insert(product);
			map.clear();
			map.put("respCode", 0);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("respCode", 1);
		}
		return map;
	}
	
	/**
	 * 分页查询(时间倒叙排列)
	 * @return
	 */
	@RequestMapping(value="findByPage/{pageSize}/{pageNo}",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Map<String, Object> findByPage(@PathVariable int pageSize, @PathVariable int pageNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> param = new HashMap<String, Object>();
		//分页参数
		param.put("expireTime", DateUtils.DateToString(new Date(), "yyyy-MM-dd HH:mm:ss"));
		
		Page<Product> page = productService.findByPage("findProductByPage",param,pageNo,pageSize);
		map.put("page", page);
		return map;
	}
	
	/**
	 * 分页查询(时间倒叙排列)
	 * @return
	 */
	@RequestMapping(value="findTypeByPage/{type}/{pageSize}/{pageNo}",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Map<String, Object> findTypeByPage(@PathVariable int type,@PathVariable int pageSize, @PathVariable int pageNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> param = new HashMap<String, Object>();
		//参数
		param.put("expireTime", DateUtils.DateToString(new Date(), "yyyy-MM-dd HH:mm:ss"));
		param.put("type", type);
		
		Page<Product> page = productService.findTypeByPage("findProductTypeByPage",param,pageNo,pageSize);
		map.put("page", page);
		return map;
	}
}
