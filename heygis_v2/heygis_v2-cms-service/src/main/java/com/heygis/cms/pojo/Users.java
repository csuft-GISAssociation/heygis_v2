package com.heygis.cms.pojo;

import java.io.Serializable;

/**
 * 用户表
 */
public class Users implements Serializable {

    private static final long serialVersionUID = -8788182097459679692L;

    private Integer uid;

    private String account;

    private String password;

    private Integer identity_id;

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

    public Integer getIdentity_id() {
        return identity_id;
    }

    public void setIdentity_id(Integer identity_id) {
        this.identity_id = identity_id;
    }

    @Override
    public String toString() {
        return "Users{" +
                "uid=" + uid +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", identityId=" + identity_id +
                '}';
    }
}