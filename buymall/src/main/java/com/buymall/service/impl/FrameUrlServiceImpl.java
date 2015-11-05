package com.buymall.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.buymall.entity.FrameUrl;
import com.buymall.mapper.FrameUrlMapper;
import com.buymall.service.FrameUrlService;
@Service
public class FrameUrlServiceImpl implements FrameUrlService{
	@Resource
	private FrameUrlMapper frameUrlMapper;

	public int deleteByPrimaryKey(Integer id) {
		return 0;
	}

	public int insert(FrameUrl record) {
		return 0;
	}

	public int insertSelective(FrameUrl record) {
		return 0;
	}

	public FrameUrl selectByPrimaryKey(Integer id) {
		return null;
	}

	public int updateByPrimaryKeySelective(FrameUrl record) {
		return 0;
	}

	public int updateByPrimaryKey(FrameUrl record) {
		return 0;
	}

	/**
	 * 查询全部
	 */
	public List<FrameUrl> selectAllUrl(int type) {
		return frameUrlMapper.selectAllUrl(type);
	}
	
	
}
