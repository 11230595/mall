package com.buymall.view;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buymall.entity.Product;
import com.buymall.service.LoginLogService;
import com.buymall.service.ProductService;
import com.buymall.service.UserService;
import com.buymall.utils.GetProduct;
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
	 * 保存
	 * @return
	 */
	@RequestMapping(value="add",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Map<String, Object> index(HttpServletRequest request,@RequestParam String url, @RequestParam String type) {
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
}
