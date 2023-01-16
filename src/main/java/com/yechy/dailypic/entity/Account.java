package com.yechy.dailypic.entity;

import java.io.Serializable;

public class Account implements Serializable {

    private int id;

    private String userName;

    private String pwd;

    private String accountId;

    private String phoneNum;

    private UserProfile userProfile;

    public Account() {
    }

    public Account(String userName, String accountId, String pwd, String phoneNum) {
        this.userName = userName;
        this.accountId = accountId;
        this.pwd = pwd;
        this.phoneNum = phoneNum;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }
}
