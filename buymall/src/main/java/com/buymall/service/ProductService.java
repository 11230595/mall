package com.buymall.service;

import java.util.Map;

import com.buymall.entity.Product;
import com.framework.core.page.Page;

public interface ProductService {
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	int deleteByPrimaryKey(String id);
	/**
	 * 插入
	 * @param record
	 * @return
	 */
    int insert(Product record);
    /**
     * 插入
     * @param record
     * @return
     */
    int insertSelective(Product record);
    /**
     * 根据主键选择
     * @param id
     * @return
     */
    Product selectByPrimaryKey(String id);
    /**
     * 选择更新
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
     * 分页查询
     * @param param
     * @param pageNo
     * @param pageSize
     * @return
     */
	Page<Product> findByPage(Map<String, Object> param, int pageNo, int pageSize);
	/**
	 * 根据类型分页查询
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	Page<Product> findTypeByPage(Map<String, Object> param, int pageNo,
			int pageSize);
}
