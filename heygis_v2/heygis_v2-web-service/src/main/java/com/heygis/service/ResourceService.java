package com.heygis.service;

import com.heygis.pojo.Condition;
import com.heygis.utils.HeyGisResult;

/**
 * 资源业务层
 */
public interface ResourceService {
    /**
     * 根据资源类型tpye分页查询资源信息
     * @param type
     * @param page
     * @return
     */
    HeyGisResult queryResourcesByType(Integer type,Integer page);

    /**
     * 根据条件分页查询资源信息
     * @param condition
     * @return
     */
    HeyGisResult queryResourcesByCondition(Condition condition);

    /**
     * 根据关键字查询资源信息
     * @param type
     * @param keyWord
     * @return
     */
    HeyGisResult queryResourcesByKeyWord(Integer type, String keyWord);
}
