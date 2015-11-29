package com.buymall.service;

import com.buymall.entity.HongBao;

public interface HongBaoService {
    int deleteByPrimaryKey(String id);

    int insert(HongBao record);

    int insertSelective(HongBao record);

    HongBao selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(HongBao record);

    int updateByPrimaryKey(HongBao record);
    //获取最新的红包
	HongBao findNowHongBao();
}
