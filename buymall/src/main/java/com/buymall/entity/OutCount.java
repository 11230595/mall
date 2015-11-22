package com.buymall.entity;

import java.util.Date;

public class OutCount {
    private String id;

    private Integer productType;

    private Integer productUserType;

    private String prodyctId;

    private String userId;

    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getProductType() {
        return productType;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    public Integer getProductUserType() {
        return productUserType;
    }

    public void setProductUserType(Integer productUserType) {
        this.productUserType = productUserType;
    }

    public String getProdyctId() {
        return prodyctId;
    }

    public void setProdyctId(String prodyctId) {
        this.prodyctId = prodyctId == null ? null : prodyctId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	public OutCount() {
		super();
	}

	public OutCount(String id, Integer productType, Integer productUserType,
			String prodyctId, String userId, Date createTime) {
		super();
		this.id = id;
		this.productType = productType;
		this.productUserType = productUserType;
		this.prodyctId = prodyctId;
		this.userId = userId;
		this.createTime = createTime;
	}
}