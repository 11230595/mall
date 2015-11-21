package com.buymall.mapper;

import com.buymall.entity.OutCount;

public interface OutCountMapper {
    int deleteByPrimaryKey(String id);

    int insert(OutCount record);

    int insertSelective(OutCount record);

    OutCount selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(OutCount record);

    int updateByPrimaryKey(OutCount record);
}