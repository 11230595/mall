package com.buymall.entity;

import java.util.Date;

public class TkProduct {
    private String id;

    private String numIid;

    private String title;

    private String pictUrl;

    private String smallImages;

    private Double reservePrice;

    private Double zkFinalPrice;

    private Integer userType;

    private String provcity;

    private String itemUrl;

    private Double sale;

    private Integer saleCount;

    private Integer type;

    private Integer status;

    private Date createTime;

    private Date expireTime;

    private Date startTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getNumIid() {
        return numIid;
    }

    public void setNumIid(String numIid) {
        this.numIid = numIid == null ? null : numIid.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getPictUrl() {
        return pictUrl;
    }

    public void setPictUrl(String pictUrl) {
        this.pictUrl = pictUrl == null ? null : pictUrl.trim();
    }

    public String getSmallImages() {
        return smallImages;
    }

    public void setSmallImages(String smallImages) {
        this.smallImages = smallImages == null ? null : smallImages.trim();
    }

    public Double getReservePrice() {
        return reservePrice;
    }

    public void setReservePrice(Double reservePrice) {
        this.reservePrice = reservePrice;
    }

    public Double getZkFinalPrice() {
        return zkFinalPrice;
    }

    public void setZkFinalPrice(Double zkFinalPrice) {
        this.zkFinalPrice = zkFinalPrice;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getProvcity() {
        return provcity;
    }

    public void setProvcity(String provcity) {
        this.provcity = provcity == null ? null : provcity.trim();
    }

    public String getItemUrl() {
        return itemUrl;
    }

    public void setItemUrl(String itemUrl) {
        this.itemUrl = itemUrl == null ? null : itemUrl.trim();
    }

    public Double getSale() {
        return sale;
    }

    public void setSale(Double sale) {
        this.sale = sale;
    }

    public Integer getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(Integer saleCount) {
        this.saleCount = saleCount;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
}