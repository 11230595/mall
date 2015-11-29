package com.buymall.mapper;

import com.buymall.entity.HongBao;

public interface HongBaoMapper {
    int deleteByPrimaryKey(String id);

    int insert(HongBao record);

    int insertSelective(HongBao record);

    HongBao selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(HongBao record);

    int updateByPrimaryKey(HongBao record);
    /**
     * 获取最新红包信息
     * @return
     */
	HongBao findNowHongBao();
}