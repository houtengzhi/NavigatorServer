package com.yechy.dailypic.entity;

import java.io.Serializable;

public class UserProfile implements Serializable {

    private int id;
    private String userName;

    private int age;

    private byte gender;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
