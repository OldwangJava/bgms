package com.hzlx.entity;

import java.util.Date;

public class BusinessInfo {
    private Integer id;
    private String busName;
    private String password;
    private String businessName;
    private String tel;
    private String address;
    private String avatar;
    private Date createTime;
    private Integer status;


    public BusinessInfo() {
    }

    public BusinessInfo(Integer id, String busName, String password, String businessName, String tel, String address, String avatar, Date createTime, Integer status) {
        this.id = id;
        this.busName = busName;
        this.password = password;
        this.businessName = businessName;
        this.tel = tel;
        this.address = address;
        this.avatar = avatar;
        this.createTime = createTime;
        this.status = status;
    }

    /**
     * 获取
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取
     * @return busName
     */
    public String getBusName() {
        return busName;
    }

    /**
     * 设置
     * @param busName
     */
    public void setBusName(String busName) {
        this.busName = busName;
    }

    /**
     * 获取
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取
     * @return businessName
     */
    public String getBusinessName() {
        return businessName;
    }

    /**
     * 设置
     * @param businessName
     */
    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    /**
     * 获取
     * @return tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置
     * @param tel
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * 获取
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取
     * @return avatar
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * 设置
     * @param avatar
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * 获取
     * @return createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    public String toString() {
        return "BusinessInfo{id = " + id + ", busName = " + busName + ", password = " + password + ", businessName = " + businessName + ", tel = " + tel + ", address = " + address + ", avatar = " + avatar + ", createTime = " + createTime + ", status = " + status + "}";
    }
}
