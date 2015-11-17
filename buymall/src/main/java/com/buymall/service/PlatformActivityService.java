package com.buymall.service;

import com.buymall.entity.PlatformActivity;

public interface PlatformActivityService {
	int deleteByPrimaryKey(String id);

    int insert(PlatformActivity record);

    int insertSelective(PlatformActivity record);

    PlatformActivity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PlatformActivity record);

    int updateByPrimaryKey(PlatformActivity record);
}
