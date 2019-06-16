package com.heygis.pojo;

import java.io.Serializable;

/**
 * 论坛言论表
 */
public class ForumPost extends ForumPostKey  implements Serializable {


    private static final long serialVersionUID = -1312325692384617926L;

    private Integer pid;

    private Integer fid;

    private Byte first;

    private String author;

    private Integer authorUid;

    private String authorAccount;

    private String subject;

    private Long dateline;

    private String userip;

    private Byte attachment;

    private Integer isReplyPost;

    private Integer beReplyUid;

    private Integer beReplyPosi;

    private Boolean deleted;

    private String message;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Byte getFirst() {
        return first;
    }

    public void setFirst(Byte first) {
        this.first = first;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public Integer getAuthorUid() {
        return authorUid;
    }

    public void setAuthorUid(Integer authorUid) {
        this.authorUid = authorUid;
    }

    public String getAuthorAccount() {
        return authorAccount;
    }

    public void setAuthorAccount(String authorAccount) {
        this.authorAccount = authorAccount == null ? null : authorAccount.trim();
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    public Long getDateline() {
        return dateline;
    }

    public void setDateline(Long dateline) {
        this.dateline = dateline;
    }

    public String getUserip() {
        return userip;
    }

    public void setUserip(String userip) {
        this.userip = userip == null ? null : userip.trim();
    }

    public Byte getAttachment() {
        return attachment;
    }

    public void setAttachment(Byte attachment) {
        this.attachment = attachment;
    }

    public Integer getIsReplyPost() {
        return isReplyPost;
    }

    public void setIsReplyPost(Integer isReplyPost) {
        this.isReplyPost = isReplyPost;
    }

    public Integer getBeReplyUid() {
        return beReplyUid;
    }

    public void setBeReplyUid(Integer beReplyUid) {
        this.beReplyUid = beReplyUid;
    }

    public Integer getBeReplyPosi() {
        return beReplyPosi;
    }

    public void setBeReplyPosi(Integer beReplyPosi) {
        this.beReplyPosi = beReplyPosi;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }
}