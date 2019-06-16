package com.heygis.pojo;

import java.io.Serializable;

/**
 * 条件实体类
 */
public class Condition implements Serializable {


    private static final long serialVersionUID = 3094828788053947616L;

    private Integer type;
    private Integer page;
    private Integer conditionId;
    private String conditionName;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getConditionId() {
        return conditionId;
    }

    public void setConditionId(Integer conditionId) {
        this.conditionId = conditionId;
    }

    public String getConditionName() {
        return conditionName;
    }

    public void setConditionName(String conditionName) {
        this.conditionName = conditionName;
    }

    @Override
    public String toString() {
        return "Condition{" +
                "type=" + type +
                ", page=" + page +
                ", conditionId=" + conditionId +
                ", conditionName='" + conditionName + '\'' +
                '}';
    }
}
