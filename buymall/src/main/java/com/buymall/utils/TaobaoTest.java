package com.buymall.utils;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TbkItemGetRequest;
import com.taobao.api.request.TbkItemInfoGetRequest;
import com.taobao.api.response.TbkItemGetResponse;
import com.taobao.api.response.TbkItemInfoGetResponse;

public class TaobaoTest {

	public static void main(String[] args) {
		String url = "http://gw.api.taobao.com/router/rest";
		String appkey = "23165118";
		String secret = "3cdf63b4863445584ed88b70d98ecbe7";
		
		try {
			//getItemList(url,appkey,secret);	//获取商品列表
			getItemDesc(url, appkey, secret);	//获取商品详情
		} catch (ApiException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 淘宝客商品查询
	 * @param url
	 * @param appkey
	 * @param secret
	 * @throws ApiException
	 */
	public static String getItemList(String url, String appkey, String secret) throws ApiException{
		TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
		TbkItemGetRequest req = new TbkItemGetRequest();
		//需返回的字段列表
		req.setFields("num_iid,title,pict_url,small_images,reserve_price,zk_final_price,user_type,provcity,item_url");
		req.setQ("女装");				//查询词
		req.setCat("16,18");		//后台类目ID，用,分割，最大10个，该ID可以通过taobao.itemcats.get接口获取到
		req.setItemloc("杭州");		//所在地
		req.setSort("total_sales");	//排序_des（降序），排序_asc（升序），销量（total_sales），淘客佣金比率（tk_rate）， 累计推广量（tk_total_sales），总支出佣金（tk_total_commi）
		req.setIsTmall(false);		//是否商城商品，设置为true表示该商品是属于淘宝商城商品，设置为false或不设置表示不判断这个属性
		req.setIsOverseas(false);	//是否海外商品，设置为true表示该商品是属于海外商品，设置为false或不设置表示不判断这个属性
		req.setStartPrice(10L);		//折扣价范围下限，单位：元
		req.setEndPrice(10L);		//折扣价范围上限，单位：元
		req.setStartTkRate(123L);	//淘客佣金比率上限，如：1234表示12.34%
		req.setEndTkRate(123L);		//淘客佣金比率上限，如：1234表示12.34%
		req.setPlatform(1L);		//链接形式：1：PC，2：无线，默认：１
		req.setPageNo(123L);		//第几页，默认：１
		req.setPageSize(20L);		//页大小，默认20，1~100
		TbkItemGetResponse rsp = client.execute(req);
		System.out.println(rsp.getBody());
		return rsp.getBody();
	}
	/**
	 * 获取商品详情 （简版）
	 * @param url
	 * @param appkey
	 * @param secret
	 * @return
	 * @throws ApiException
	 */
	public static String getItemDesc(String url, String appkey, String secret) throws ApiException{
		TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
		TbkItemInfoGetRequest req = new TbkItemInfoGetRequest();
		//需返回的字段列表
		req.setFields("num_iid,title,pict_url,small_images,reserve_price,zk_final_price,user_type,provcity,item_url");
		req.setPlatform(1L);//链接形式：1：PC，2：无线，默认：１
		req.setNumIids("527572365532");	//商品ID串，用,分割，从taobao.tbk.item.get接口获取num_iid字段，最大40个
		TbkItemInfoGetResponse rsp = client.execute(req);
		System.out.println(rsp.getBody());
		return rsp.getBody();
	}
}
