package com.buymall.utils;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import com.buymall.vo.ItemListRequestVO;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TbkItemGetRequest;
import com.taobao.api.request.TbkItemInfoGetRequest;
import com.taobao.api.response.TbkItemGetResponse;
import com.taobao.api.response.TbkItemInfoGetResponse;

public class TKUtils {
	
	public static void main(String[] args) {
		ItemListRequestVO itemListRequestVO = new ItemListRequestVO("女装", ItemListRequestVO.SORT_SALES, false, 1L, 10L, 0L, 99L);
		String result = getItemList(itemListRequestVO);
	}
	
	private static String[] sorts = {"_des","_asc","total_sales","tk_rate","tk_total_sales","tk_total_commi"};
	
	/**
	 * 淘宝客商品查询
	 * @param url
	 * @param appkey
	 * @param secret
	 * @throws ApiException
	 */
	public static String getItemList(ItemListRequestVO itemRequest){
		TaobaoClient client = new DefaultTaobaoClient(itemRequest.URL, itemRequest.APPKEY, itemRequest.SECRET);
		TbkItemGetRequest req = new TbkItemGetRequest();
		//需返回的字段列表
		req.setFields("num_iid,title,pict_url,small_images,reserve_price,zk_final_price,user_type,provcity,item_url");
		req.setQ(itemRequest.getQ());				//查询词
		if(StringUtils.isNotBlank(itemRequest.getItemloc())){
			req.setItemloc(itemRequest.getItemloc());		//所在地
		}
		if(ArrayUtils.contains(sorts, itemRequest.getSort())){
			req.setSort(itemRequest.getSort());	//排序_des（降序），排序_asc（升序），销量（total_sales），淘客佣金比率（tk_rate）， 累计推广量（tk_total_sales），总支出佣金（tk_total_commi）
		}
		req.setIsTmall(itemRequest.getIsTmall());		//是否商城商品，设置为true表示该商品是属于淘宝商城商品，设置为false或不设置表示不判断这个属性
		req.setIsOverseas(itemRequest.getIsOverseas());	//是否海外商品，设置为true表示该商品是属于海外商品，设置为false或不设置表示不判断这个属性
		if(itemRequest.getStartPrice() > 0){
			req.setStartPrice(itemRequest.getStartPrice());		//折扣价范围下限，单位：元
		}
		if(itemRequest.getEndPrice() > 0){
			req.setEndPrice(itemRequest.getEndPrice());		//折扣价范围上限，单位：元
		}
		//req.setStartTkRate(123L);	//淘客佣金比率下限，如：1234表示12.34%
		//req.setEndTkRate(123L);		//淘客佣金比率上限，如：1234表示12.34%
		//req.setPlatform(1L);		//链接形式：1：PC，2：无线，默认：１
		if(itemRequest.getPageNo() > 0){
			req.setPageNo(itemRequest.getPageNo());		//第几页，默认：１
		}
		if(itemRequest.getPageSize() > 0){
			req.setPageSize(itemRequest.getPageSize());		//页大小，默认20，1~100
		}
		TbkItemGetResponse rsp = null;
		try {
			rsp = client.execute(req);
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	public static String getItemDesc(String url, String appkey, String secret,String id){
		TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
		TbkItemInfoGetRequest req = new TbkItemInfoGetRequest();
		//需返回的字段列表
		req.setFields("num_iid,title,pict_url,small_images,reserve_price,zk_final_price,user_type,provcity,item_url");
		req.setPlatform(1L);//链接形式：1：PC，2：无线，默认：１
		req.setNumIids(id);	//商品ID串，用,分割，从taobao.tbk.item.get接口获取num_iid字段，最大40个
		TbkItemInfoGetResponse rsp = null;
		try {
			rsp = client.execute(req);
		} catch (ApiException e) {
			e.printStackTrace();
		}
		System.out.println(rsp.getBody());
		return rsp.getBody();
	}
}
