package com.buymall.entity;

import java.util.Date;

public class OutCount {
    private String id;

    private Integer productType;

    private Integer productUserType;

    private String userId;

    private Date cretaTime;

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Date getCretaTime() {
        return cretaTime;
    }

    public void setCretaTime(Date cretaTime) {
        this.cretaTime = cretaTime;
    }

	public OutCount() {
		super();
	}

	public OutCount(String id, Integer productType, Integer productUserType,
			String userId, Date cretaTime) {
		super();
		this.id = id;
		this.productType = productType;
		this.productUserType = productUserType;
		this.userId = userId;
		this.cretaTime = cretaTime;
	}
    
    
}