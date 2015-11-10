package com.mobilemall.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.framework.core.mybatis.BaseMybatisDao;
import com.framework.core.page.Page;
import com.mobilemall.entity.Product;
import com.mobilemall.mapper.ProductMapper;
import com.mobilemall.service.ProductService;
/**
 * 
 * @author zhoudong
 *
 */
@Service
public class ProductServiceImpl extends BaseMybatisDao implements ProductService {

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

	public Product selectByPrimaryKey(String id) {
		return productMapper.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(Product record) {
		return productMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(Product record) {
		return productMapper.updateByPrimaryKey(record);
	}
	
	/**
	 * 分页查询
	 */
	public Page<Product> findByPage(Map<String, Object> param, int pageNo,
			int pageSize) {
		return (Page<Product>) findByPageBySqlId("findProductByPage", param, pageNo, pageSize);
	}
	/**
	 * 根据类型分页查询
	 */
	public Page<Product> findTypeByPage(Map<String, Object> param,
			int pageNo, int pageSize) {
		return (Page<Product>) findByPageBySqlId("findProductByPage", param, pageNo, pageSize);
	}

}
