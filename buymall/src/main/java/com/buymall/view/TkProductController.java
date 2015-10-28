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

import com.buymall.entity.Product;
import com.buymall.entity.TkProduct;
import com.buymall.entity.User;
import com.buymall.service.LoginLogService;
import com.buymall.service.ProductService;
import com.buymall.service.TkProductService;
import com.buymall.service.UserService;
import com.buymall.utils.GetProduct;
import com.buymall.utils.TKUtils;
import com.buymall.vo.ItemListRequestVO;
import com.framework.core.page.Page;
import com.framework.core.utils.DateUtils;
import com.taobao.api.ApiException;
/**
 * 产品类
 * @author zhoudong
 *
 */
@Controller
@RequestMapping("tp")
public class TkProductController {
	private static Logger logger = Logger.getLogger(TkProductController.class);
	@Resource
	private TkProductService tkProductService;
	
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
			String smallImg = beanJson.optJSONObject("small_images").optString("string");
			beanJson.element("small_images", smallImg.substring(1,smallImg.length()-1));
			TkProduct tkProduct = (TkProduct) JSONObject.toBean(beanJson, TkProduct.class);
			
			tkProduct.setItemUrl(beanJson.optString("item_url")+"&ali_trackid=2:mm_18774322_6466308_22486110");
			tkProduct.setNumIid(beanJson.optString("num_iid"));
			tkProduct.setPictUrl(beanJson.optString("pict_url"));
			tkProduct.setReservePrice(beanJson.optDouble("reserve_price"));
			tkProduct.setSmallImages(beanJson.optString("small_images"));
			tkProduct.setUserType(beanJson.optInt("user_type"));
			tkProduct.setZkFinalPrice(beanJson.optDouble("zk_final_price"));
			tkProduct.setSale(tkProduct.getZkFinalPrice()/(tkProduct.getReservePrice()/10));
			tkProduct.setType(itemRequest.getType());
			tkProduct.setId(UUID.randomUUID().toString());
			tkProductService.insert(tkProduct);
		}
		
		map.put("respCode", 0);
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
		
		Page<TkProduct> page = tkProductService.findByPage(param,pageNo,pageSize);
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
		
		Page<TkProduct> page = tkProductService.findTypeByPage(param,pageNo,pageSize);
		map.put("page", page);
		return map;
	}
}
