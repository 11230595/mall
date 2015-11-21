package com.buymall.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;

import com.buymall.entity.Product;
import com.buymall.mapper.ProductMapper;
import com.buymall.service.ProductService;
import com.buymall.vo.ProductVO;
import com.framework.core.mybatis.BaseMybatisDao;
import com.framework.core.page.Page;
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

	@Override
	public Page<Product> findProductByMemberId(Map<String, Object> param,
			int pageNo, int pageSize) {
		return (Page<Product>) findByPageBySqlId("findProductByMemberId", param, pageNo, pageSize);
	}
	/**
	 * 保存产品
	 */
	@Override
	public Map<String, Object> addTkProduct(ProductVO productVO) {
		Map<String, Object> map = new HashMap<String, Object>();
		Product product = new Product();
		if(productVO.getUserType() == 2)
			productVO.setReservePrice(productVO.getReservePrice().substring(1,productVO.getReservePrice().length()));
		try {
			BeanUtils.copyProperties(product, productVO);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		product.setPictUrl(productVO.getImgUrl());
		product.setSale(product.getZkFinalPrice()/(product.getReservePrice()/10));
		try {
			insert(product);
			map.put("respCode", 0);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("respCode", 1);
		}
		return map;
	}

}
