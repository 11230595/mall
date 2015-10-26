package com.buymall.service;

import com.buymall.entity.Product;

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
}
