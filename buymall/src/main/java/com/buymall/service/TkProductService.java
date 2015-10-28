package com.buymall.service;

import java.util.Map;

import com.buymall.entity.Product;
import com.buymall.entity.TkProduct;
import com.framework.core.page.Page;

public interface TkProductService {
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
    int insert(TkProduct record);
    /**
     * 插入
     * @param record
     * @return
     */
    int insertSelective(TkProduct record);
    /**
     * 根据主键选择
     * @param id
     * @return
     */
    TkProduct selectByPrimaryKey(String id);
    /**
     * 选择更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(TkProduct record);
    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(TkProduct record);
    /**
     * 分页查询
     * @param param
     * @param pageNo
     * @param pageSize
     * @return
     */
	Page<TkProduct> findByPage(Map<String, Object> param, int pageNo, int pageSize);
	/**
	 * 根据类型分页查询
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	Page<TkProduct> findTypeByPage(Map<String, Object> param, int pageNo,
			int pageSize);
}
