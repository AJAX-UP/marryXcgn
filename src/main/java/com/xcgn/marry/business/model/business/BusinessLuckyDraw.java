package com.xcgn.marry.business.model.business;

import java.util.Date;

public class BusinessLuckyDraw {
    private Integer id;

    private Integer cashBean;

    private Integer cashBeanDouble;

    private Integer userId;

    private Integer number;

    private Date createTime;

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

    public Integer getCashBeanDouble() {
        return cashBeanDouble;
    }

    public void setCashBeanDouble(Integer cashBeanDouble) {
        this.cashBeanDouble = cashBeanDouble;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}