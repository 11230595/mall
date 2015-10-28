package com.buymall.mapper;

import com.buymall.entity.TkProduct;

public interface TkProductMapper {
    int deleteByPrimaryKey(String id);

    int insert(TkProduct record);

    int insertSelective(TkProduct record);

    TkProduct selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TkProduct record);

    int updateByPrimaryKey(TkProduct record);
}