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
		
		if(type == 12){ //九块九专区
			if(title.contains("外套") || title.contains("衬衫") || title.contains("T恤") ||  title.contains("裤子")
					|| title.contains("羽绒服") || title.contains("毛衫") || title.contains("卫衣") ||title.contains("牛仔裤")
					||	title.contains("休闲裤")){
				return getType(title,1);
			}
			if(title.contains("女装") || title.contains("打底裤")){
				return 1;
			}
			if(title.contains("男装")){
				return 2;
			}
			if(title.contains("内衣")){
				return 3;
			}
			if(title.contains("鞋")){
				return 4;
			}
			if(title.contains("吃")){
				return 8;
			}
			if(title.contains("包") || title.contains("箱")){
				return 10;
			}
		}
		return type;
	}
}
