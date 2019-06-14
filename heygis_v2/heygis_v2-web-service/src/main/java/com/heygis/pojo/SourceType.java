package com.heygis.pojo;

import java.io.Serializable;

/**
 * 资源类型表
 */
public class SourceType  implements Serializable {
    private Integer tid;

    private String type;

    private String name;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}