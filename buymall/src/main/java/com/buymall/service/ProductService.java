package com.buymall.service;

import java.util.Map;

import com.buymall.entity.Product;
import com.framework.core.page.Page;
/**
 * 产品
 * @author zhoudong
 *
 */
public interface ProductService {
	/**
	 * 删除
	 * @param id
	 * @return
	 */
    int deleteByPrimaryKey(String id);
    /**
     * 保存
     * @param record
     * @return
     */
    int insert(Product record);
    /**
     * 保存
     * @param record
     * @return
     */
    int insertSelective(Product record);
    /**
     * 根据主键查询
     * @param id
     * @return
     */
    Product findProductById(String id);
    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Product record);
    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(Product record);
    /**
     * 分页查询，倒叙排列
     * @param sqlId
     * @param param
     * @param pageNo
     * @param pageSize
     * @return
     */
	Page<Product> findByPage(Map<String, Object> param,
			int pageNo, int pageSize);
	
	/**
	 * 分页查询，根据类型，倒叙排列
	 * @param sqlId
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	Page<Product> findTypeByPage(Map<String, Object> param,
			int pageNo, int pageSize);
}
