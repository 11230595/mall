package com.mobilemall.service;

import java.util.List;

import com.mobilemall.entity.FrameUrl;

public interface FrameUrlService {
	int deleteByPrimaryKey(Integer id);

    int insert(FrameUrl record);

    int insertSelective(FrameUrl record);

    FrameUrl selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FrameUrl record);

    int updateByPrimaryKey(FrameUrl record);
    
    List<FrameUrl> selectAllUrl(int type);
}
