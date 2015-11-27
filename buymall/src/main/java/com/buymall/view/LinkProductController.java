package com.buymall.view;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
import org.springframework.web.servlet.ModelAndView;

import com.buymall.entity.LinkProduct;
import com.buymall.entity.Member;
import com.buymall.entity.OutCount;
import com.buymall.entity.Product;
import com.buymall.entity.User;
import com.buymall.service.LinkProductService;
import com.buymall.service.OutCountService;
import com.buymall.service.ProductService;
import com.buymall.utils.GetIframeProduct;
import com.buymall.utils.GetProduct;
import com.buymall.utils.TKUtils;
import com.buymall.vo.ItemListRequestVO;
import com.buymall.vo.ProductVO;
import com.framework.core.page.Page;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.IDUtils;
/**
 * 产品类
 * @author zhoudong
 *
 */
@Controller
@RequestMapping("link")
public class LinkProductController {
	private static Logger logger = Logger.getLogger(LinkProductController.class);
	@Resource
	private OutCountService outCountService;
	@Resource
	private LinkProductService linkProductService;
	
	/**
	 * 外部商品保存，用户专区展示
	 * @return
	 */
	@RequestMapping(value="add",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Map<String, Object> saveProductTkActivity(HttpServletRequest request,
			@RequestParam String url, @RequestParam String type,@RequestParam Integer day,@RequestParam Integer userType) {
		List<Map<String, Object>> list = GetIframeProduct.autoSaveTaoBaoKeActivity(url);
		Map<String, Object> respMap = new HashMap<String, Object>();
		LinkProduct product = null;
		try {
			for (Map<String, Object> map : list) {
				product = new LinkProduct();
				BeanUtils.populate(product, map);
				product.setId(IDUtils.getId());
				product.setType(Integer.parseInt(type));
				product.setStatus(0);
				product.setExpireTime(DateUtils.addDay(new Date(), day));
				product.setStartTime(new Date());
				product.setCreateTime(new Date());
				product.setUserType(userType);
				product.setSale(product.getZkFinalPrice()/(product.getReservePrice()/10));
				linkProductService.insert(product);
			}
			respMap.put("respCode", 0);
		} catch (Exception e) {
			respMap.put("respCode", 1);
		}
		return respMap;
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
		
		Page<LinkProduct> page = linkProductService.findByPage(param,pageNo,pageSize);
		map.put("page", page);
		return map;
	}
	
	/**
	 * 记录流出流量
	 * @return
	 */
	@RequestMapping(value="out/{id}",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView tbOut(HttpServletRequest requst,@PathVariable String id) {
		ModelAndView mav = new ModelAndView("out");
		LinkProduct product = linkProductService.selectByPrimaryKey(id);
		if(product != null){
			User user = (User) requst.getSession().getAttribute("user");
			outCountService.insert(new OutCount(IDUtils.getId(), product.getType(), 
					product.getUserType(),product.getId(), user == null ? "未登陆用户" : user.getUserId(), new Date()));
		}
		mav.addObject("product", product);
		return mav;
	}
	
	/**
	 * 分页查询(时间倒叙排列)
	 * @return
	 */
	@RequestMapping(value="delete/{id}",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Map<String, Object> delete(@PathVariable String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			linkProductService.deleteByPrimaryKey(id);
			map.put("respCode", 0);
		} catch (Exception e) {
			map.put("respCode", 1);
		}
		return map;
	}
	
	/**
	 * 修改时间，重新排序
	 * @return
	 */
	@RequestMapping(value="changeTime",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Map<String, Object> changeTime() {
		Map<String, Object> map = new HashMap<String, Object>();
		linkProductService.updateChangeTime();
		map.put("result", "重新排序成功");
		return map;
	}
}
