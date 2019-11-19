package com.xcgn.marry.business.model.business;

import java.util.List;

public class BusinessCardList {
    private Integer id;

    private String avatar;

    private Integer sort;

    private String winningPicture;

    private Double maxMoney;

    private List<BusinessWrongPicture> wrongPictures;


    public List<BusinessWrongPicture> getWrongPictures() {
        return wrongPictures;
    }

    public void setWrongPictures(List<BusinessWrongPicture> wrongPictures) {
        this.wrongPictures = wrongPictures;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getWinningPicture() {
        return winningPicture;
    }

    public void setWinningPicture(String winningPicture) {
        this.winningPicture = winningPicture == null ? null : winningPicture.trim();
    }

    public Double getMaxMoney() {
        return maxMoney;
    }

    public void setMaxMoney(Double maxMoney) {
        this.maxMoney = maxMoney;
    }
}