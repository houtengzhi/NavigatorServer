package com.yechy.dailypic.entity;

import java.io.Serializable;

public class Account implements Serializable {

    private String name;

    private String accountId;

    private String pwd;

    private String phoneNum;

    private DpUser user;

    public Account() {
    }

    public Account(String name, String accountId, String pwd, String phoneNum) {
        this.name = name;
        this.accountId = accountId;
        this.pwd = pwd;
        this.phoneNum = phoneNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public DpUser getUser() {
        return user;
    }

    public void setUser(DpUser user) {
        this.user = user;
    }
}
