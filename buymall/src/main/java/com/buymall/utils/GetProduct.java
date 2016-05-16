package com.buymall.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.buymall.exception.BuyMallException;
import com.buymall.vo.ItemListRequestVO;
/**
 * 获取产品
 * @author zhoudong
 *
 */
public class GetProduct {

	public static void main(String[] args) throws BuyMallException {
		/*String url = "https://detail.tmall.com/item.htm?id=527572365532&ali_trackid=2:mm_18774322_11774819_41742628:1463402394_2k2_198447214&pvid=50_122.71.74.96_267_1463402163723";
		Map<String, Object> map = autoSaveProduct(url,1);
		
		for(Map.Entry<String, Object> entry : map.entrySet()){
			System.out.println(entry.getKey() + "---->" + entry.getValue());
		}*/
		
		autoSaveTaoBaoOrTmall("https://detail.tmall.com/item.htm?id=527572365532&ali_trackid=2:mm_18774322_11774819_41742628:1463402394_2k2_198447214&pvid=50_122.71.74.96_267_1463402163723");
	}
	
	public static Map<String, Object> autoSaveAiTaoBao(String getUrl){
		Document doc = null;
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			doc = Jsoup.connect(getUrl).timeout(4000).get();
			map.put("error", "0");//错误信息
		} catch (IOException e) {
			e.printStackTrace();
			map.put("error", "1");//错误信息  0,简介成功，1，连接失败
		}
		String itemUrl = doc.select(".item-title").select("a").attr("href");
		map.put("itemUrl", StringUtils.isBlank(itemUrl) ? "" : itemUrl.substring(2, itemUrl.length()));
		map.put("title", doc.select(".item-title").select("a").text());//爱淘宝标题
		map.put("imgUrl", doc.select("#J_test").attr("src"));//爱淘宝图片
		map.put("buyCount", doc.select(".info-sell").select("a").text());//爱淘宝销量
		map.put("collectCount", doc.select(".info-fav").select("a").text());//收藏数
		map.put("surplusCount", doc.select(".info-store").select("a").text());//库存量
		map.put("scoreCount", doc.select(".left-score").select("a").text());//得分
		map.put("price", doc.select(".price-promo").select("strong").text());//爱淘宝销量
		map.put("actDesc", doc.select(".price-dic").text());//活动关键词
		map.put("reservePrice", doc.select(".price-ori-num").text());//原价
		map.put("zkFinalPrice", doc.select(".price-promo").select("strong").text());//折后价
		
		String platform = doc.select(".tmall-tag").text();
		map.put("platform", StringUtils.isBlank(platform) ? "淘宝" : platform);//平台
		map.put("userType", 2);//平台类型 0-淘宝，1-天猫，2-爱淘宝
		
		return map;
	}
	/**
	 * 根据平台类型，自动抓取产品并返回信息用于业务保存
	 * @param url
	 * @param userType
	 * @return
	 */
	public static Map<String, Object> autoSaveProduct(String url,
			Integer userType) {
		
		switch (userType) {
		case 0: //淘宝
			return autoSaveTaoBao(url);
		case 1: //天猫
			return autoSaveTmall(url);
		case 3: //京东
			return autoSaveJd(url);
		default:
			break;
		}
		return null;
	}
	/**
	 * 天猫自动京东
	 * @param url
	 * @return 
	 */
	public static Map<String, Object> autoSaveJd(String url) {
		Document doc = null;
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			doc = Jsoup.connect(url).timeout(4000).get();
			map.put("error", "0");//错误信息
		} catch (IOException e) {
			e.printStackTrace();
			map.put("error", "1");//错误信息  0,简介成功，1，连接失败
		}
		map.put("title", doc.select("#name").select("h1").text());//京东标题
		map.put("imgUrl", doc.select("#spec-n1").select("img").attr("src"));//淘宝图片
		
		map.put("platform", "京东");//平台
		map.put("userType", 3);//平台类型 0-淘宝，1-天猫，2-爱淘宝
		
		return map;
	}

	/**
	 * 天猫自动保存
	 * @param url
	 * @return 
	 */
	public static Map<String, Object> autoSaveTmall(String url) {
		Document doc = null;
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			doc = Jsoup.connect(url).timeout(4000).get();
			map.put("error", "0");//错误信息
		} catch (IOException e) {
			e.printStackTrace();
			map.put("error", "1");//错误信息  0,简介成功，1，连接失败
		}
		
		System.out.println(doc.toString());
		
		map.put("itemUrl", url);
		map.put("title", doc.select(".tb-detail-hd").select("h1").text());//淘宝标题
		map.put("imgUrl", doc.select("#J_ImgBooth").attr("src"));//淘宝图片
		map.put("zkFinalPrice", doc.select(".tm-price").text());//价格
		map.put("reservePrice", doc.select(".J_StrPrice").select(".tb-rmb-num").text());//原价
		
		map.put("platform", "天猫");//平台
		map.put("userType", 1);//平台类型 0-淘宝，1-天猫，2-爱淘宝
		
		return map;
	}

	/**
	 * 淘宝自动保存
	 * @param url
	 * @return 
	 */
	public static Map<String, Object> autoSaveTaoBao(String url) {
		Document doc = null;
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			doc = Jsoup.connect(url).timeout(4000).get();
			map.put("error", "0");//错误信息
		} catch (IOException e) {
			e.printStackTrace();
			map.put("error", "1");//错误信息  0,简介成功，1，连接失败
		}
		map.put("itemUrl", url);
		map.put("title", doc.select("#J_Title").select(".tb-main-title").text());//淘宝标题
		map.put("imgUrl", doc.select("#J_ImgBooth").attr("src"));//淘宝图片
		map.put("zkFinalPrice", doc.select("#J_PromoPriceNum").text());//价格
		map.put("reservePrice", doc.select(".J_StrPrice").select(".tb-rmb-num").text());//原价
		
		map.put("platform", "淘宝");//平台
		map.put("userType", 0);//平台类型 0-淘宝，1-天猫，2-爱淘宝
		
		return map;
	}
	
	/**
	 * 淘宝客去掉中间页以后，使用这个导入
	 * @param url
	 * @return 
	 * @throws BuyMallException 
	 */
	public static Map<String, Object> autoSaveTaoBaoOrTmall(String url) throws BuyMallException {
		if(StringUtils.isBlank(url)){
			throw new BuyMallException("url 不能是空！");
		}
		if(! url.contains("?") && url.contains("&")){
			throw new BuyMallException("url 不合法！");
		}
		ItemListRequestVO itemRequest = new ItemListRequestVO();
		String id = url.split("\\?")[1].split("\\&")[0].split("=")[1];
		String result = TKUtils.getItemDesc(itemRequest.URL, itemRequest.APPKEY, itemRequest.SECRET,id);
		JSONObject jsonObject = JSONObject.fromObject(result);
		
		JSONArray jsonArray = jsonObject.optJSONObject("tbk_item_info_get_response").optJSONObject("results").optJSONArray("n_tbk_item");
		Map<String, Object> map = new HashMap<String, Object>();
		for(int i=0; i<jsonArray.size(); i++){
			JSONObject json = jsonArray.optJSONObject(i);
			
			map.put("itemUrl", url);
			map.put("title", json.optString("title"));//淘宝标题
			map.put("imgUrl", json.optString("pict_url"));//淘宝图片
			map.put("zkFinalPrice", json.optString("zk_final_price"));//价格
			map.put("reservePrice", json.optString("reserve_price"));//原价
			int userType = json.optInt("user_type");
			map.put("platform", userType == 0 ? "淘宝" : "天猫");//平台
			map.put("userType", userType);//平台类型 0-淘宝，1-天猫，2-爱淘宝
		}
		
		return map;
	}
}
