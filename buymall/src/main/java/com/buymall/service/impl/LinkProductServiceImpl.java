package com.buymall.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.buymall.entity.LinkProduct;
import com.buymall.entity.Product;
import com.buymall.mapper.LinkProductMapper;
import com.buymall.service.LinkProductService;
import com.framework.core.mybatis.BaseMybatisDao;
import com.framework.core.page.Page;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.IDUtils;
/**
 * 外部数据
 * @author zhoudong
 *
 */
@Service
public class LinkProductServiceImpl extends BaseMybatisDao implements LinkProductService{
	@Resource
	private LinkProductMapper linkProductMapper;
	
	@Override
	public int deleteByPrimaryKey(String id) {
		return linkProductMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(LinkProduct record) {
		return linkProductMapper.insert(record);
	}

	@Override
	public int insertSelective(LinkProduct record) {
		return linkProductMapper.insertSelective(record);
	}

	@Override
	public LinkProduct selectByPrimaryKey(String id) {
		return linkProductMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(LinkProduct record) {
		return linkProductMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(LinkProduct record) {
		return linkProductMapper.updateByPrimaryKey(record);
	}

	@Override
	public void updateChangeTime() {
		//TODO
		List<LinkProduct> list = linkProductMapper.findAdllShowProduct(DateUtils.DateToString(new Date(), "yyyy-MM-dd HH:mm:ss"));

		for(LinkProduct product : list){
			product.setCreateTime(DateUtils.addSecond(product.getCreateTime(), IDUtils.getRandom()));
			linkProductMapper.updateByPrimaryKeySelective(product);
		}
	}
	
	@Override
	public Page<LinkProduct> findByPage(Map<String, Object> param, int pageNo,
			int pageSize) {
		//TODO
		return (Page<LinkProduct>) findByPageBySqlId("findLinkProductByPage", param, pageNo, pageSize);
	}

}
