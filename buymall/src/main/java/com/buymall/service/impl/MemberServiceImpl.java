package com.buymall.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.buymall.entity.Member;
import com.buymall.mapper.MemberMapper;
import com.buymall.service.MemberService;
/**
 * 会员
 * @author zhoudong
 *
 */
@Service
public class MemberServiceImpl implements MemberService {
	@Resource
	private MemberMapper memberMapper;
	
	public int deleteByPrimaryKey(String id) {
		return memberMapper.deleteByPrimaryKey(id);
	}

	public int insert(Member record) {
		return memberMapper.insert(record);
	}

	public int insertSelective(Member record) {
		return memberMapper.insertSelective(record);
	}

	public Member selectByPrimaryKey(String id) {
		return memberMapper.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(Member record) {
		return memberMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(Member record) {
		return memberMapper.updateByPrimaryKey(record);
	}

}
