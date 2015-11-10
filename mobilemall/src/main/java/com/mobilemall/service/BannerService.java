package com.mobilemall.service;

import java.util.List;

import com.framework.core.page.Page;
import com.mobilemall.entity.Banner;

public interface BannerService {
	/**
	 * 删除
	 * @param id
	 * @return
	 */
    int deleteByPrimaryKey(String id);
    /**
     * 插入
     * @param record
     * @return
     */
    int insert(Banner record);
    /**
     * 插入
     * @param record
     * @return
     */
    int insertSelective(Banner record);
    /**
     * 根据主键查询
     * @param id
     * @return
     */
    Banner selectByPrimaryKey(String id);
    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Banner record);
    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(Banner record);
    /**
     * 分页查询海报
     * @param bannerType 
     * @return
     */
	Page<Banner> findByPage(int bannerType);
	/**
	 * 查询全部
	 * @return
	 */
	List<Banner> findAll();
}
