package com.buymall.mapper;

import com.buymall.entity.PlatformActivity;

public interface PlatformActivityMapper {
    int deleteByPrimaryKey(String id);

    int insert(PlatformActivity record);

    int insertSelective(PlatformActivity record);

    PlatformActivity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PlatformActivity record);

    int updateByPrimaryKey(PlatformActivity record);
}