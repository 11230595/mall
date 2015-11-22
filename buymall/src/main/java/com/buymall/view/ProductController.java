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
import org.springframework.web.servlet.ModelAndView;

import com.buymall.entity.Member;
import com.buymall.entity.OutCount;
import com.buymall.entity.Product;
import com.buymall.entity.User;
import com.buymall.service.OutCountService;
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
	@Resource
	private OutCountService outCountService;
	
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
			product.setItemUrl(beanJson.optString("item_url")+"&ali_trackid=2:mm_18774322_11774819_41742628&pvid=200_10.98.16.176_77082_1447942174662&pid=mm_18774322_11774819_41732376");
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
		productVO.setCreateTime(new Date());
		productVO.setUserType(2);
		productVO.setScore(String.valueOf(map.get("scoreCount")));
		
		return productService.addTkProduct(productVO);
	}
	
	/**
	 * 保存商品(京东，单个保存)
	 * @return
	 */
	@RequestMapping(value="add_jd",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Map<String, Object> saveJdProdecut(HttpServletRequest request,ProductVO productVO, @RequestParam String catchUrl) {
		Map<String, Object> map = GetProduct.autoSaveJd(catchUrl);
		try {
			BeanUtils.populate(productVO, map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		productVO.setId(UUID.randomUUID().toString());
		productVO.setStatus(0);
		productVO.setExpireTime(DateUtils.addDay(new Date(), 3));
		productVO.setStartTime(new Date());
		productVO.setCreateTime(new Date());
		productVO.setScore(String.valueOf(map.get("scoreCount")));
		
		return productService.addTkProduct(productVO);
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
	
	/**
	 * 记录流出流量
	 * @return
	 */
	@RequestMapping(value="out/{id}",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView tbOut(HttpServletRequest requst,@PathVariable String id) {
		ModelAndView mav = new ModelAndView("out");
		Product product = productService.selectByPrimaryKey(id);
		if(product != null){
			User user = (User) requst.getSession().getAttribute("user");
			outCountService.insert(new OutCount(UUID.randomUUID().toString(), product.getType(), 
					product.getUserType(),product.getId(), user == null ? "未登陆用户" : user.getUserId(), new Date()));
		}
		mav.addObject("product", product);
		return mav;
	}
	
	/**
	 * 分页查询(根据用户ID查询本人浏览过的商品)
	 * @return
	 */
	@RequestMapping(value="findBrowseHistory/{userId}/{pageSize}/{pageNo}",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Map<String, Object> findBrowseHistory(@PathVariable String userId,@PathVariable int pageSize, @PathVariable int pageNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> param = new HashMap<String, Object>();
		//参数
		param.put("userId", userId);
		
		Page<Product> page = productService.findBrowseHistory(param,pageNo,pageSize);
		map.put("page", page);
		return map;
	}
	
	/**
	 * 分页查询(时间倒叙排列)
	 * @return
	 */
	@RequestMapping(value="delete/{id}",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Map<String, Object> delete(@PathVariable String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			productService.deleteByPrimaryKey(id);
			map.put("respCode", 0);
		} catch (Exception e) {
			map.put("respCode", 1);
		}
		return map;
	}
}
