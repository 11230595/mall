package com.buymall.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.buymall.entity.Product;
import com.buymall.mapper.ProductMapper;
import com.buymall.service.ProductService;
/**
 * 产品
 * @author zhoudong
 *
 */
@Service
public class ProductServiceImpl implements ProductService {
	@Resource
	private ProductMapper productMapper;

	public int deleteByPrimaryKey(String id) {
		return productMapper.deleteByPrimaryKey(id);
	}

	public int insert(Product record) {
		return productMapper.insert(record);
	}

	public int insertSelective(Product record) {
		return productMapper.insertSelective(record);
	}

	public Product findProductById(String id) {
		return productMapper.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(Product record) {
		return productMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(Product record) {
		return productMapper.updateByPrimaryKey(record);
	}
	
}
