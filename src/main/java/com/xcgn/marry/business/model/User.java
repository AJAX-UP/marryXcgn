package com.xcgn.marry.business.model;

import java.util.Date;
import java.util.List;

/**
 * 用户表
 * 
 * @author wcyong
 * 
 * @date 2019-11-10
 */
public class User {
    /**
     * ID
     */
    private Integer id;

    /**
     * 头像
     */
    private Integer avatarId;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 状态：1启用、0禁用
     */
    private Integer enabled;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户名
     */
    private String username;

    /**
     * 电话
     */
    private String phone;

    /**
     * 创建日期
     */
    private Date createTime;

    /**
     * 最后修改密码的日期
     */
    private Date lastPasswordResetTime;

    /**
     * 出生日期
     */
    private Date birthday;

    /**
     * 所属省Id
     */
    private Integer proviceId;

    /**
     * 城市id
     */
    private Integer cityId;

    /**
     * 性别
     */
    private Boolean gender;

    /**
     * 个性签名
     */
    private String personalizedSignature;

    /**
     * 用户类型（1为app用户，2为后台管理用户）
     */
    private Integer userType;


    private List<Role> roleList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAvatarId() {
        return avatarId;
    }

    public void setAvatarId(Integer avatarId) {
        this.avatarId = avatarId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastPasswordResetTime() {
        return lastPasswordResetTime;
    }

    public void setLastPasswordResetTime(Date lastPasswordResetTime) {
        this.lastPasswordResetTime = lastPasswordResetTime;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getProviceId() {
        return proviceId;
    }

    public void setProviceId(Integer proviceId) {
        this.proviceId = proviceId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getPersonalizedSignature() {
        return personalizedSignature;
    }

    public void setPersonalizedSignature(String personalizedSignature) {
        this.personalizedSignature = personalizedSignature == null ? null : personalizedSignature.trim();
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }
}