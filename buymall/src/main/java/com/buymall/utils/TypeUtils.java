package com.buymall.utils;
/**
 * 获取类型 工具类
 * @author zhoudong
 *
 */
public class TypeUtils {
	
	private static String[] yifus = {"外套","衬衫","T恤","裤","羽绒服","毛衫","卫衣","牛仔裤","休闲裤","长袖","修身","显瘦","袄","哈伦","马甲"};
	private static String[] xiaochis = {"吃","食","水果","罐头","枣","枸杞","茶","普洱","干货","木耳","蘑菇","蜂蜜","辣椒","大米","黄小米"};
	private static String[] meizhuangs = {"美甲","香水","指甲","皮筋","饰品","发卡","耳环","耳钉","香水","指环","戒指","洗发水","洗面奶","口红",
		"洁面乳","胭脂","眼线","妆","假发","面部","乳液","润肤乳","美白","唇膏","香脂"};
	
	/**
	 * 获取类型
	 * @param title 标题
	 * @param type 类型
	 * @return
	 */
	public static int getType(String title,int type){
		if(type ==1 || type ==2){
			if(title.contains("女")){
				return 1;
			}else if (title.contains("男")) {
				return 2;
			}
			return type;
		}
		
		if(type == 4 || type == 10){
			if(title.contains("鞋") || title.contains("靴")){
				return 4;
			}else if (title.contains("包") || title.contains("箱")) {
				return 10;
			}
			return type;
		}
		if(type == 12 || type == 7){ //九块九专区
			//衣服
			for(String yifu : yifus){
				if(title.contains(yifu))
					return getType(title,1);
			}
			//美食
			for(String xiaochi : xiaochis){
				if(title.contains(xiaochi))
					return 8;
			}
			//美妆
			for(String meizhuang : meizhuangs){
				if(title.contains(meizhuang))
					return 11;
			}
			
			if(title.contains("女装") || title.contains("打底裤")  ||	title.contains("裙")|| title.contains("吊带")){
				return 1;
			}
			if(title.contains("男装")){
				return 2;
			}
			if(title.contains("内衣") || title.contains("胸罩") || title.contains("裤头") 
					|| title.contains("内裤") || title.contains("袜")){
				return 3;
			}
			if(title.contains("鞋")){
				return 4;
			}
			
			if(title.contains("壳") || title.contains("膜") || title.contains("耳机") || title.contains("电源")){
				return 9;
			}
			if(title.contains("包") || title.contains("箱")){
				return 10;
			}
		}
		return type;
	}
}
