package com.heygis.pojo;

import java.io.Serializable;

/**
 * 用户表
 */
public class Users implements Serializable {
    private Integer uid;

    private String account;

    private String password;

    private Integer identityId;

    public Users(){}

    public Users(String account,String password){
        this.account = account;
        this.password = password;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getIdentityId() {
        return identityId;
    }

    public void setIdentityId(Integer identityId) {
        this.identityId = identityId;
    }

    @Override
    public String toString() {
        return "Users{" +
                "uid=" + uid +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", identityId=" + identityId +
                '}';
    }
}