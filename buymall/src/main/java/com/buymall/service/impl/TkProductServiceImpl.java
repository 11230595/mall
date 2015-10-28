package com.buymall.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.buymall.entity.Product;
import com.buymall.entity.TkProduct;
import com.buymall.mapper.TkProductMapper;
import com.buymall.service.TkProductService;
import com.framework.core.mybatis.BaseMybatisDao;
import com.framework.core.page.Page;
/**
 * 
 * @author zhoudong
 *
 */
@Service
public class TkProductServiceImpl extends BaseMybatisDao implements TkProductService {

	@Resource
	private TkProductMapper tkProductMapper;
	
	public int deleteByPrimaryKey(String id) {
		return tkProductMapper.deleteByPrimaryKey(id);
	}

	public int insert(TkProduct record) {
		return tkProductMapper.insert(record);
	}

	public int insertSelective(TkProduct record) {
		return tkProductMapper.insertSelective(record);
	}

	public TkProduct selectByPrimaryKey(String id) {
		return tkProductMapper.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(TkProduct record) {
		return tkProductMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(TkProduct record) {
		return tkProductMapper.updateByPrimaryKey(record);
	}
	
	/**
	 * 分页查询
	 */
	public Page<TkProduct> findByPage(Map<String, Object> param, int pageNo,
			int pageSize) {
		return (Page<TkProduct>) findByPageBySqlId("findTkProductByPage", param, pageNo, pageSize);
	}
	/**
	 * 根据类型分页查询
	 */
	public Page<TkProduct> findTypeByPage(Map<String, Object> param,
			int pageNo, int pageSize) {
		return (Page<TkProduct>) findByPageBySqlId("findTkProductTypeByPage", param, pageNo, pageSize);
	}

}
