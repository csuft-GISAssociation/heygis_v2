package com.heygis.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户信息表
 */
public class UsersInfo  implements Serializable {
    private static final long serialVersionUID = 6779663846568170770L;

    private Integer uid;

    private String account;

    private Integer age;

    private String gender;

    private String mail;

    private String tel;

    private String qq;

    private String selfintroduction;

    private Date birthday;

    private Integer identityId;

    private String name;

    private String icon_img;

    private String grade;

    private String nickname;

    public UsersInfo(){}

    public UsersInfo(String nickname,String grade){
        this.nickname = nickname;
        this.grade = grade;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail == null ? null : mail.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getSelfintroduction() {
        return selfintroduction;
    }

    public void setSelfintroduction(String selfintroduction) {
        this.selfintroduction = selfintroduction == null ? null : selfintroduction.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getIdentityId() {
        return identityId;
    }

    public void setIdentityId(Integer identityId) {
        this.identityId = identityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIcon_img() {
        return icon_img;
    }

    public void setIcon_img(String icon_img) {
        this.icon_img = icon_img;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    @Override
    public String toString() {
        return "UsersInfo{" +
                "uid=" + uid +
                ", account='" + account + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", mail='" + mail + '\'' +
                ", tel='" + tel + '\'' +
                ", qq='" + qq + '\'' +
                ", selfintroduction='" + selfintroduction + '\'' +
                ", birthday=" + birthday +
                ", identityId=" + identityId +
                ", name='" + name + '\'' +
                ", icon_img='" + icon_img + '\'' +
                ", grade='" + grade + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}