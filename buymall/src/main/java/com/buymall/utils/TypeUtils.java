package com.buymall.utils;
/**
 * 获取类型 工具类
 * @author zhoudong
 *
 */
public class TypeUtils {
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
		}
		
		if(type == 4 || type == 10){
			if(title.contains("鞋") || title.contains("靴")){
				return 4;
			}else if (title.contains("包") || title.contains("箱")) {
				return 10;
			}
		}
		
		if(type == 12 || type == 7){ //九块九专区
			if(title.contains("外套") || title.contains("衬衫") || title.contains("T恤") ||  title.contains("裤子") 
					|| title.contains("羽绒服") || title.contains("毛衫") || title.contains("卫衣") ||title.contains("牛仔裤")
					||	title.contains("休闲裤")|| title.contains("长袖")){
				return getType(title,1);
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
			if(title.contains("吃") || title.contains("食") || title.contains("水果") || title.contains("罐头")
					|| title.contains("枣") || title.contains("枸杞")|| title.contains("茶") || title.contains("普洱")
					|| title.contains("干货") || title.contains("木耳") || title.contains("蘑菇") || title.contains("蜂蜜")){
				return 8;
			}
			if(title.contains("壳") || title.contains("膜") || title.contains("耳机") || title.contains("电源")){
				return 9;
			}
			if(title.contains("包") || title.contains("箱")){
				return 10;
			}
			
			if(title.contains("美甲") || title.contains("香水") || title.contains("指甲") || title.contains("皮筋")
					|| title.contains("饰品") || title.contains("发卡") || title.contains("耳环") || title.contains("耳钉")
					|| title.contains("香水") || title.contains("指环") || title.contains("戒指") || title.contains("洗发水")
					|| title.contains("洗面奶") || title.contains("口红") || title.contains("洁面乳") || title.contains("胭脂")
					|| title.contains("眼线") || title.contains("妆") || title.contains("假发") || title.contains("面部")
					|| title.contains("乳液") || title.contains("润肤乳")|| title.contains("美白") || title.contains("唇膏")
					|| title.contains("香脂")){
				return 10;
			}
		}
		return type;
	}
}
