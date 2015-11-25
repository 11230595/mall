package com.buymall.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GetIframeProduct {
	
	public static void main(String[] args) {
		String url = "http://temai.taobao.com/floor499664.htm?q=2U9HBQN90FsN%2BoQUE6FNzAjvNWmyHlA7PpAuVVaE3e0heab8UPVsbDK%2Bb8xUnTq8U0zMjq%2BJQjVwvug%2B6yLtDAZGbuHleVecbuVQQVBce5CwD6b8F5HT1w%3D%3D";
		autoSaveTaoBaoKeActivity(url);
	}
	/**
	 * 淘宝客活动，自动抓去
	 * @param getUrl
	 * @return
	 */
	public static List<Map<String, Object>> autoSaveTaoBaoKeActivity(String getUrl){
		Document doc = null;
		Map<String, Object> map = null;
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		try {
			doc = Jsoup.connect(getUrl).timeout(4000).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Elements elements =  doc.select("li");
		
		for(Element element : elements){
			map = new HashMap<String, Object>();
			String itemUrl = element.select("a").attr("href");
			String title = element.select(".title_line	span").text();
			String imgUrl = element.select(".cpnt_center_img").select("img").attr("data-ks-lazyload");
			String reservePrice = element.select(".original_price ").text();//原价
			String zkFinalPrice =element.select(".discount_price").text(); //现价
			String buyCount =element.select(".sold").text(); //现价
			
			map.put("itemUrl", itemUrl); //商品地址
			map.put("title", title);		//标题
			map.put("imgUrl", imgUrl);		//图片地址
			map.put("reservePrice", reservePrice.replace("¥", "")); //原价
			map.put("zkFinalPrice", zkFinalPrice.replace("¥", ""));	//现价
			map.put("buyCount", buyCount.replace("月销量", ""));	//现价
			map.put("platform", "9块9特卖"); //因为无法区分，所以统一存储成淘宝
			map.put("userType", 10);//9块9特卖
			
			list.add(map);
		}
		
		return list;
	}
}
