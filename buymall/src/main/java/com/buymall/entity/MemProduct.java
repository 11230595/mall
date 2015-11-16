package com.buymall.entity;

import java.util.Date;

public class MemProduct {
    private String id;

    private String memberId;

    private String productId;

    private Date createTime;

    private String bz1;

    private String bz2;

    private String bz3;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId == null ? null : memberId.trim();
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getBz1() {
        return bz1;
    }

    public void setBz1(String bz1) {
        this.bz1 = bz1 == null ? null : bz1.trim();
    }

    public String getBz2() {
        return bz2;
    }

    public void setBz2(String bz2) {
        this.bz2 = bz2 == null ? null : bz2.trim();
    }

    public String getBz3() {
        return bz3;
    }

    public void setBz3(String bz3) {
        this.bz3 = bz3 == null ? null : bz3.trim();
    }

	public MemProduct() {
		super();
	}

	public MemProduct(String id, String memberId, String productId,
			Date createTime) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.productId = productId;
		this.createTime = createTime;
	}
    
    
}