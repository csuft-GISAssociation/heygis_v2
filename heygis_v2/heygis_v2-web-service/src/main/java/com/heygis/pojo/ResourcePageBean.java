package com.heygis.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * 资源分页实体类
 */
public class ResourcePageBean implements Serializable {

    private static final long serialVersionUID = 3227293824112500997L;

    //当前页
    private Integer currentPage;

    //总页数
    private Integer totalPage;

    //每页个数 每页12个 用double和Math.ceil配合
    public static final Integer size = 12;

    //总个数
    private long totalCount;

    //资源对象
    private List<Sources> sources;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage() {
        this.totalPage = (int)Math.ceil((totalCount/(double)size));
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public List<Sources> getSources() {
        return sources;
    }

    public void setSources(List<Sources> sources) {
        this.sources = sources;
    }
}
