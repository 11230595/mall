package com.buymall.entity;

import java.util.Date;

public class Member {
    private String id;

    private String userId;

    private Integer status;

    private Integer level;

    private Date createTime;

    private String memberDesc;

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

	public Member(String id, String userId, Integer status, Integer level,
			Date createTime, String memberDesc) {
		super();
		this.id = id;
		this.userId = userId;
		this.status = status;
		this.level = level;
		this.createTime = createTime;
		this.memberDesc = memberDesc;
	}

	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Member(String id, String userId) {
		super();
		this.id = id;
		this.userId = userId;
	}
    
    
}