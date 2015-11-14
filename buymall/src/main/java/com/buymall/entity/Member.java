package com.buymall.entity;

import java.util.Date;

public class Member {
    private String id;

    private String userId;

    private Integer status;

    private Integer level;

    private Date createTime;

    private String memberDesc;

    private String phoneNum;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getMemberDesc() {
        return memberDesc;
    }

    public void setMemberDesc(String memberDesc) {
        this.memberDesc = memberDesc == null ? null : memberDesc.trim();
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum == null ? null : phoneNum.trim();
    }

	public Member() {
		super();
	}

	public Member(String id, String userId, Integer status, Integer level,
			String phoneNum) {
		super();
		this.id = id;
		this.userId = userId;
		this.status = status;
		this.level = level;
		this.phoneNum = phoneNum;
	}

	public Member(String userId, Integer status) {
		super();
		this.userId = userId;
		this.status = status;
	}

	public Member(String userId, Integer status, String phoneNum) {
		super();
		this.userId = userId;
		this.status = status;
		this.phoneNum = phoneNum;
	}
    
	
}