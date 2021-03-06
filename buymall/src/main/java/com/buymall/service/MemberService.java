package com.buymall.service;

import com.buymall.entity.Member;
/**
 * 会员
 * @author zhoudong
 *
 */
public interface MemberService {
	int deleteByPrimaryKey(String id);

    int insert(Member record);

    int insertSelective(Member record);

    Member selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Member record);

    int updateByPrimaryKey(Member record);

	Member findMemberByUserId(String userId, int status);
	/**
	 * 更新商户状态
	 * @param userId
	 * @param i
	 */
	void updateMemberStatus(Member member);
}
