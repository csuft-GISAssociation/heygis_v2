package com.heygis.pojo;

import java.io.Serializable;

public class ForumPostKey  implements Serializable {


    private static final long serialVersionUID = 7945001684017724824L;

    private Integer tid;

    private Integer position;

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
}