package com.buymall.service;

import java.util.Map;

import com.buymall.entity.PlatformActivity;
import com.buymall.entity.Product;
import com.framework.core.page.Page;

public interface PlatformActivityService {
	int deleteByPrimaryKey(String id);

    int insert(PlatformActivity record);

    int insertSelective(PlatformActivity record);

    PlatformActivity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PlatformActivity record);

    int updateByPrimaryKey(PlatformActivity record);

    /**
     * 
     * @param param
     * @param pageNo
     * @param pageSize
     * @return
     */
	Page<PlatformActivity> findByPage(Map<String, Object> param, int pageNo, int pageSize);
}
