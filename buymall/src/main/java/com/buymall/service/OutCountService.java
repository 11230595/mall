package com.buymall.service;

import com.buymall.entity.OutCount;

/**
 * 走出流量记录
 * @author zhoudong
 *
 */
public interface OutCountService {
	int deleteByPrimaryKey(String id);

    int insert(OutCount record);

    int insertSelective(OutCount record);

    OutCount selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(OutCount record);

    int updateByPrimaryKey(OutCount record);
}
