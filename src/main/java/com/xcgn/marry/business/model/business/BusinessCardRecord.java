package com.xcgn.marry.business.model.business;

import java.util.Date;

public class BusinessCardRecord {
    private Integer id;

    private Integer cardId;

    private Integer userId;

    private Date createDate;

    private Integer cashBean;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getCashBean() {
        return cashBean;
    }

    public void setCashBean(Integer cashBean) {
        this.cashBean = cashBean;
    }
}