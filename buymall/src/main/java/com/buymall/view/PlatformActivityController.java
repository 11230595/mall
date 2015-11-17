package com.buymall.view;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buymall.entity.Member;
import com.buymall.entity.Product;
import com.buymall.service.ProductService;
import com.buymall.utils.GetProduct;
import com.buymall.utils.TKUtils;
import com.buymall.vo.ItemListRequestVO;
import com.buymall.vo.ProductVO;
import com.framework.core.page.Page;
import com.framework.core.utils.DateUtils;
/**
 * 产品类
 * @author zhoudong
 *
 */
@Controller
@RequestMapping("hd")
public class PlatformActivityController {
	private static Logger logger = Logger.getLogger(PlatformActivityController.class);
	@Resource
	private ProductService productService;
	
	/**
	 * 保存平台活动
	 * @return
	 */
	@RequestMapping(value="add",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Map<String, Object> saveProduct(ItemListRequestVO itemRequest) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("respCode", 0);
		return map;
	}
}
