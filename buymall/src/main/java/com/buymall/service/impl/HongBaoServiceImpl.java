package com.buymall.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.buymall.entity.HongBao;
import com.buymall.mapper.HongBaoMapper;
import com.buymall.service.HongBaoService;

/**
 * 红包
 * @author zhoudong
 *
 */
@Service
public class HongBaoServiceImpl implements HongBaoService{
	@Resource
	private HongBaoMapper hongBaoMapper;

	@Override
	public int deleteByPrimaryKey(String id) {
		return hongBaoMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(HongBao record) {
		return hongBaoMapper.insert(record);
	}

	@Override
	public int insertSelective(HongBao record) {
		return hongBaoMapper.insertSelective(record);
	}

	@Override
	public HongBao selectByPrimaryKey(String id) {
		return hongBaoMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(HongBao record) {
		return hongBaoMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(HongBao record) {
		return hongBaoMapper.updateByPrimaryKey(record);
	}
	//获取最新的红包
	@Override
	public HongBao findNowHongBao() {
		return hongBaoMapper.findNowHongBao();
	}
	
}
