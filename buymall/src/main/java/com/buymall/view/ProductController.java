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
@RequestMapping("product")
public class ProductController {
	private static Logger logger = Logger.getLogger(ProductController.class);
	@Resource
	private ProductService productService;
	
	/**
	 * 保存商品
	 * @return
	 */
	@RequestMapping(value="add",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Map<String, Object> saveProduct(ItemListRequestVO itemRequest) {
		Map<String, Object> map = new HashMap<String, Object>();
		String result = TKUtils.getItemList(itemRequest);
		JSONObject jsonObject = JSONObject.fromObject(result);
		JSONArray jsonArray = jsonObject.optJSONObject("tbk_item_get_response").optJSONObject("results").optJSONArray("n_tbk_item");
		
		if(jsonArray.size() < 0){
			map.put("respCode", "2");
		}
		
		for(int i=0; i<jsonArray.size(); i++){
			JSONObject beanJson = jsonArray.getJSONObject(i);
			
			String imgUrl = beanJson.optJSONObject("small_images").optJSONArray("string").optString(0);
			String smallImg = beanJson.optJSONObject("small_images").optString("string");
			beanJson.element("small_images", smallImg.substring(1,smallImg.length()-1));
			Product product = (Product) JSONObject.toBean(beanJson, Product.class);
			
			product.setImgUrl(imgUrl);
			product.setItemUrl(beanJson.optString("item_url")+"&ali_trackid=2:mm_18774322_6466308_22486110");
			product.setNumIid(beanJson.optString("num_iid"));
			product.setPictUrl(beanJson.optString("pict_url"));
			product.setReservePrice(beanJson.optDouble("reserve_price"));
			product.setSmallImages(beanJson.optString("small_images"));
			product.setUserType(beanJson.optInt("user_type"));
			product.setZkFinalPrice(beanJson.optDouble("zk_final_price"));
			product.setSale(product.getZkFinalPrice()/(product.getReservePrice()/10));
			product.setExpireTime(DateUtils.addDay(new Date(), 3));
			product.setStartTime(new Date());
			product.setType(itemRequest.getType());
			product.setId(UUID.randomUUID().toString());
			productService.insert(product);
		}
		
		map.put("respCode", 0);
		return map;
	}
	
	/**
	 * 保存商品(爱淘宝，单个保存)
	 * @return
	 */
	@RequestMapping(value="add_itaobao",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Map<String, Object> saveProduct(HttpServletRequest request,@RequestParam String url, @RequestParam String type) {
		Map<String, Object> map = GetProduct.autoSaveAiTaoBao(url);
		ProductVO productVO = new ProductVO();
		try {
			BeanUtils.populate(productVO, map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		productVO.setId(UUID.randomUUID().toString());
		productVO.setType(Integer.parseInt(type));
		productVO.setStatus(0);
		productVO.setItemUrl(url); //因为跳转不到淘宝，暂时跳转到爱淘宝
		productVO.setExpireTime(DateUtils.addDay(new Date(), 3));
		productVO.setStartTime(new Date());
		productVO.setScore(String.valueOf(map.get("scoreCount")));
		
		return addTkProduct(productVO);
	}
	public Map<String, Object> addTkProduct(ProductVO productVO) {
		Map<String, Object> map = new HashMap<String, Object>();
		Product product = new Product();
		productVO.setReservePrice(productVO.getReservePrice().substring(1,productVO.getReservePrice().length()));
		try {
			BeanUtils.copyProperties(product, productVO);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		product.setPictUrl(productVO.getImgUrl());
		//product.setUserType(productVO.getPlatform().equals("天猫") ? 1 : 0);
		product.setSale(product.getZkFinalPrice()/(product.getReservePrice()/10));
		try {
			productService.insert(product);
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
		
		Page<Product> page = productService.findByPage(param,pageNo,pageSize);
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
		param.put("userType", type);
		
		Page<Product> page = productService.findTypeByPage(param,pageNo,pageSize);
		map.put("page", page);
		return map;
	}
}
