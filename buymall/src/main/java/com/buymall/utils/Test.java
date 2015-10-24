package com.buymall.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Test {

	public static void main(String[] args) {
		String url = "http://redirect.simba.taobao.com/rd?w=unionnojs&f=http%3A%2F%2Fai.taobao.com%2Fauction%2Fedetail.htm%3Fe%3D5wHuvXgEAXTuDAZjWhpTWEeDw1Z%252FUn1SKDTWVub3jJJBWJVBnwmj7tnO073KpEUuesayvrQ7hvkEwiwEAUVRm%252Fr4c8w8d32Rs2vARpeSUotqrKpcqC%252FWnlRmtaud%252B0v%252BxAR4DpyIxRK30T7H6cltKQ%253D%253D%26ptype%3D100010%26from%3Dbasic&k=5ccfdb950740ca16&c=un&b=alimm_0&p=mm_18774322_6466308_22486110";
		Map<String, String> map = autoSaveAiTaoBao(url);
		
		for(Map.Entry<String, String> entry : map.entrySet()){
			System.out.println(entry.getKey() + "---->" + entry.getValue());
		}
	}
	
	public static Map<String, String> autoSaveAiTaoBao(String getUrl){
		Document doc = null;
		Map<String, String> map = new HashMap<String, String>();
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
		
		return map;
	}
}
