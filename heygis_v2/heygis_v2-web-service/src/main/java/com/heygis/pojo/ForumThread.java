package com.heygis.pojo;

import java.io.Serializable;

/**
 * 论坛帖子表
 */
public class ForumThread  implements Serializable {
    private Integer tid;

    private Integer fid;

    private Short typeid;

    private Short sortid;

    private String author;

    private Integer authorUid;

    private String authorAccount;

    private String subject;

    private Long dateline;

    private Long lastpost;

    private String lastposter;

    private Integer lastposterUid;

    private Integer views;

    private Integer replies;

    private Byte attachment;

    private Integer closed;

    private Short status;

    private Integer display;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Short getTypeid() {
        return typeid;
    }

    public void setTypeid(Short typeid) {
        this.typeid = typeid;
    }

    public Short getSortid() {
        return sortid;
    }

    public void setSortid(Short sortid) {
        this.sortid = sortid;
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

    public Long getLastpost() {
        return lastpost;
    }

    public void setLastpost(Long lastpost) {
        this.lastpost = lastpost;
    }

    public String getLastposter() {
        return lastposter;
    }

    public void setLastposter(String lastposter) {
        this.lastposter = lastposter == null ? null : lastposter.trim();
    }

    public Integer getLastposterUid() {
        return lastposterUid;
    }

    public void setLastposterUid(Integer lastposterUid) {
        this.lastposterUid = lastposterUid;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Integer getReplies() {
        return replies;
    }

    public void setReplies(Integer replies) {
        this.replies = replies;
    }

    public Byte getAttachment() {
        return attachment;
    }

    public void setAttachment(Byte attachment) {
        this.attachment = attachment;
    }

    public Integer getClosed() {
        return closed;
    }

    public void setClosed(Integer closed) {
        this.closed = closed;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Integer getDisplay() {
        return display;
    }

    public void setDisplay(Integer display) {
        this.display = display;
    }
}