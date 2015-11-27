package com.buymall.service;

import java.util.Map;

import com.buymall.entity.LinkProduct;
import com.buymall.entity.Product;
import com.framework.core.page.Page;

public interface LinkProductService {
	int deleteByPrimaryKey(String id);

    int insert(LinkProduct record);

    int insertSelective(LinkProduct record);

    LinkProduct selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(LinkProduct record);

    int updateByPrimaryKey(LinkProduct record);
    /**
     * 重新排序
     */
	void updateChangeTime();
	/**
	 * 分页查询商品
	 * @param param
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	Page<LinkProduct> findByPage(Map<String, Object> param, int pageNo, int pageSize);
}
