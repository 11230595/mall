package com.buymall.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.buymall.entity.MemProduct;
import com.buymall.mapper.MemProductMapper;
import com.buymall.service.MemProductService;
/**
 * 会员商品表
 * @author zhoudong
 *
 */
@Service
public class MenProductServiceImpl implements MemProductService{
	@Resource
	private MemProductMapper memProductMapper;

	public int deleteByPrimaryKey(String id) {
		return memProductMapper.deleteByPrimaryKey(id);
	}

	public int insert(MemProduct record) {
		return memProductMapper.insert(record);
	}

	public int insertSelective(MemProduct record) {
		return memProductMapper.insertSelective(record);
	}

	public MemProduct selectByPrimaryKey(String id) {
		return memProductMapper.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(MemProduct record) {
		return memProductMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(MemProduct record) {
		return memProductMapper.updateByPrimaryKey(record);
	}

	@Override
	public void deleteByProductId(String productId) {
		memProductMapper.deleteByProductId(productId);
	}
	
	
}
