package com.buymall.mapper;

import java.util.List;

import com.buymall.entity.LinkProduct;

public interface LinkProductMapper {
    int deleteByPrimaryKey(String id);

    int insert(LinkProduct record);

    int insertSelective(LinkProduct record);

    LinkProduct selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(LinkProduct record);

    int updateByPrimaryKey(LinkProduct record);

	List<LinkProduct> findAdllShowProduct(String date);
}