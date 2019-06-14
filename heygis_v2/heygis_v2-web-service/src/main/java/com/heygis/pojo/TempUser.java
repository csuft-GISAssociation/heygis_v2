package com.heygis.pojo;

import java.io.Serializable;

/**
 * 临时用户实体 ，包含用户表和用户信息表
 */
public class TempUser implements Serializable {


    private String account;
    private String password;
    private String nickname;
    private String grade;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    /**
     * 创建用户
     * @return
     */
   public  Users createUser(){
        return  new Users(account,password);
   }

    /**
     * 创建用户信息
     * @return
     */
   public  UsersInfo createUserInfo(){
       return  new UsersInfo(nickname,grade);
   }






}
