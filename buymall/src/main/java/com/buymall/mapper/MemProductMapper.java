package com.buymall.mapper;

import com.buymall.entity.MemProduct;

public interface MemProductMapper {
    int deleteByPrimaryKey(String id);

    int insert(MemProduct record);

    int insertSelective(MemProduct record);

    MemProduct selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MemProduct record);

    int updateByPrimaryKey(MemProduct record);
    /**
     * 根据产品ID删除
     * @param productId
     */
	void deleteByProductId(String productId);
}