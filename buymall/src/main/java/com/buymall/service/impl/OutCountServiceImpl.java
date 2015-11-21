package com.buymall.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.buymall.entity.OutCount;
import com.buymall.mapper.OutCountMapper;
import com.buymall.service.OutCountService;
/**
 * 走出流量记录
 * @author zhoudong
 *
 */
@Service
public class OutCountServiceImpl implements OutCountService {
	@Resource
	private OutCountMapper outCountMapper;

	@Override
	public int deleteByPrimaryKey(String id) {
		return outCountMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(OutCount record) {
		return outCountMapper.insert(record);
	}

	@Override
	public int insertSelective(OutCount record) {
		return outCountMapper.insertSelective(record);
	}

	@Override
	public OutCount selectByPrimaryKey(String id) {
		return outCountMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(OutCount record) {
		return outCountMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(OutCount record) {
		return outCountMapper.updateByPrimaryKey(record);
	}
	
	
}
