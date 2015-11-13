package com.buymall.mapper;

import com.buymall.entity.Member;

public interface MemberMapper {
    int deleteByPrimaryKey(String id);

    int insert(Member record);

    int insertSelective(Member record);

    Member selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Member record);

    int updateByPrimaryKey(Member record);
    /**
     * 根据userId查询会员
     * @param userId
     * @return
     */
	Member findMemberByUserId(String userId);
}