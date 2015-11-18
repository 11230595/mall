package com.buymall.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.buymall.entity.PlatformActivity;
import com.buymall.entity.Product;
import com.buymall.mapper.PlatformActivityMapper;
import com.buymall.service.PlatformActivityService;
import com.framework.core.mybatis.BaseMybatisDao;
import com.framework.core.page.Page;

/**
 * 各平台活动
 * @author zhoudong
 *
 */
@Service
public class PlatformActivityServiceImpl extends BaseMybatisDao implements PlatformActivityService {
	@Resource
	private PlatformActivityMapper platformActivityMapper;

	@Override
	public int deleteByPrimaryKey(String id) {
		return platformActivityMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(PlatformActivity record) {
		return platformActivityMapper.insert(record);
	}

	@Override
	public int insertSelective(PlatformActivity record) {
		return platformActivityMapper.insertSelective(record);
	}

	@Override
	public PlatformActivity selectByPrimaryKey(String id) {
		return platformActivityMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(PlatformActivity record) {
		return platformActivityMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(PlatformActivity record) {
		return platformActivityMapper.updateByPrimaryKey(record);
	}

	@Override
	public	Page<PlatformActivity> findByPage(Map<String, Object> param, int pageNo,
			int pageSize) {
		return (Page<PlatformActivity>) findByPageBySqlId("findActivityByPage", param, pageNo, pageSize);
	}
	
}
