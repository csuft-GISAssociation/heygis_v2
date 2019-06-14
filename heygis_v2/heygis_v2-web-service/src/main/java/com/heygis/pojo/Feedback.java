package com.heygis.pojo;

import java.io.Serializable;

/**
 * 意见反馈表
 */
public class Feedback  implements Serializable {
    private Integer id;

    private String account;

    private String nickname1;

    private String time;

    private String feedbackcontent;

    private String accountimg;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getNickname1() {
        return nickname1;
    }

    public void setNickname1(String nickname1) {
        this.nickname1 = nickname1 == null ? null : nickname1.trim();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public String getFeedbackcontent() {
        return feedbackcontent;
    }

    public void setFeedbackcontent(String feedbackcontent) {
        this.feedbackcontent = feedbackcontent == null ? null : feedbackcontent.trim();
    }

    public String getAccountimg() {
        return accountimg;
    }

    public void setAccountimg(String accountimg) {
        this.accountimg = accountimg == null ? null : accountimg.trim();
    }
}