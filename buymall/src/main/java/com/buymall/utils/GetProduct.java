package com.buymall.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
/**
 * 获取产品
 * @author zhoudong
 *
 */
public class GetProduct {

	public static void main(String[] args) {
		String url = "http://ai.taobao.com/auction/edetail.htm?e=QSGVxzzyfvi6k0Or%2B%2BH4tJV4TNWlht7Cm7kUtxZzUh2LltG5xFicOdXrTUTgh9sMDPIwxrc30rgxfUmn3z%2FE3AqJIJEX%2BikKLakP2cazicSjGvRGGdqoum3abJM7sDg2tjS618V%2BwtOdDV%2FJ%2F%2Fm36w%3D%3D&ptype=100010&from=basic&clk1=c309c3ce21cd5f4b56af491971697601&upsid=c309c3ce21cd5f4b56af491971697601";
		Map<String, Object> map = autoSaveAiTaoBao(url);
		
		for(Map.Entry<String, Object> entry : map.entrySet()){
			System.out.println(entry.getKey() + "---->" + entry.getValue());
		}
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
		String platform = doc.select(".tmall-tag").text();
		map.put("platform", StringUtils.isBlank(platform) ? "淘宝" : platform);//平台
		
		return map;
	}
}
