package com.heygis.pojo;

import java.io.Serializable;

/**
 * 论坛消息表
 */
public class ForumMsg  implements Serializable {


    private static final long serialVersionUID = -2882060277632443886L;

    private Integer mid;

    private String author;

    private Integer authorUid;

    private Integer rdUid;

    private String subject;

    private Long dateline;

    private Byte type;

    private Integer fid;

    private Integer tid;

    private Integer position;

    private Byte isNew;

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
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

    public Integer getRdUid() {
        return rdUid;
    }

    public void setRdUid(Integer rdUid) {
        this.rdUid = rdUid;
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

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Byte getIsNew() {
        return isNew;
    }

    public void setIsNew(Byte isNew) {
        this.isNew = isNew;
    }
}