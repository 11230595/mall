package com.buymall.queue;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.buymall.constants.Constants;
import com.buymall.service.LinkProductService;
import com.buymall.service.ProductService;
import com.buymall.service.UserService;
import com.buymall.view.ProductController;
import com.framework.core.spring.SpringContextHolder;
import com.framework.core.utils.HTTPUtils;


/**
 * @title 修改时间，达到自动排序的目的
 * @author zhoudong
 *
 */
public class AutoChangeTime {
	private static Logger logger = Logger.getLogger(ProductController.class);
	@Autowired
	private ProductService productService;
	@Autowired
	private LinkProductService linkProductService;
	/**
	 * @title 重新排序，首页产品
	 */
	public void autoChangeTime(){
		logger.info("修改时间，打乱排序方式开始......");
		long startTime = System.currentTimeMillis();
		
		productService.updateChangeTime();
		long endTime = System.currentTimeMillis();
		logger.info("修改时间，打乱排序方式结束......共用时---》" + (endTime - startTime));
	};
	
	/**
	 * @title 专区产品
	 */
	public void autoChangeTimeByLink(){
		logger.info("专区商品--》修改时间，打乱排序方式开始......");
		long startTime = System.currentTimeMillis();
		
		linkProductService.updateChangeTime();
		long endTime = System.currentTimeMillis();
		logger.info("专区商品--》修改时间，打乱排序方式结束......共用时---》" + (endTime - startTime));
	};
}
