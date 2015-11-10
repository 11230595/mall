package com.buymall.mapper;

import java.util.List;

import com.buymall.entity.FrameUrl;

public interface FrameUrlMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FrameUrl record);

    int insertSelective(FrameUrl record);

    FrameUrl selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FrameUrl record);

    int updateByPrimaryKey(FrameUrl record);
    
    List<FrameUrl> selectAllUrl(int type);
}