package com.mobilemall.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.framework.core.mybatis.BaseMybatisDao;
import com.framework.core.page.Page;
import com.mobilemall.entity.Banner;
import com.mobilemall.mapper.BannerMapper;
import com.mobilemall.service.BannerService;
/**
 * 海报
 * @author zhoudong
 *
 */
@Service
public class BannerServiceImpl extends BaseMybatisDao implements BannerService{
	@Resource
	private BannerMapper bannerMapper;

	public int deleteByPrimaryKey(String id) {
		return bannerMapper.deleteByPrimaryKey(id);
	}

	public int insert(Banner record) {
		return bannerMapper.insert(record);
	}

	public int insertSelective(Banner record) {
		return bannerMapper.insertSelective(record);
	}

	public Banner selectByPrimaryKey(String id) {
		return bannerMapper.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(Banner record) {
		return bannerMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(Banner record) {
		return bannerMapper.updateByPrimaryKey(record);
	}
	/**
	 * 分页查询海报
	 */
	public Page<Banner> findByPage(int bannerType) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bannerType", bannerType);
		return (Page<Banner>) findByPageBySqlId("findByPage", map, 1, 4);
	}
	/**
	 * 查询全部
	 */
	public List<Banner> findAll() {
		return bannerMapper.findAll();
	}
}
