package com.xcgn.marry.business.model.business;

import java.util.Date;

public class BusinessIncomeRecord {
    private Integer id;

    private Integer cashBean;

    private Double cash;

    private Date createTime;

    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCashBean() {
        return cashBean;
    }

    public void setCashBean(Integer cashBean) {
        this.cashBean = cashBean;
    }

    public Double getCash() {
        return cash;
    }

    public void setCash(Double cash) {
        this.cash = cash;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}