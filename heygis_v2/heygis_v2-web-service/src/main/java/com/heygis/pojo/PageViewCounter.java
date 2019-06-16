package com.heygis.pojo;

/**
 * 浏览记录表
 */

import java.io.Serializable;
import java.util.Date;

public class PageViewCounter  implements Serializable {

    private static final long serialVersionUID = 6642740984497743490L;

    private Integer id;

    private String ip;

    private Date time;

    private String userAgent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent == null ? null : userAgent.trim();
    }
}